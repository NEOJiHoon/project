const alertPlaceholder = document.getElementById('liveAlertPlaceholder')  // 부트스트랩 얼럿기능

const alert = (message, type) => {          // 부트스트랩 얼럿기능
    const wrapper = document.createElement('div')
    wrapper.innerHTML = [
        `<div class="alert alert-${type} alert-dismissible" role="alert">`,
        `   <div>${message}</div>`,
        '   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>',
        '</div>'
    ].join('')

    alertPlaceholder.append(wrapper)
}

function deleteItem(itemId) {
    console.log('삭제할거임', itemId);

    $.ajax({
        type : "POST",            // HTTP method type(GET, POST) 형식이다.
        url : "/del/" + itemId,      // 컨트롤러에서 대기중인 URL 주소이다.
        // data : params,            // Json 형식의 데이터이다.
        success : function(data){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            // 응답코드 > 0000
            console.log(data);
            if (data == 1) {
                alert('삭제되었습니다.', 'danger')
                getItemList();
            } else if (data == 0) {
                alert("삭제할 대상이 없습니다.");
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            alert("통신 실패.")
        }
    });
}

function getItemList() {
    // ajax 통신
    $.ajax({
        type : "GET",            // HTTP method type(GET, POST) 형식이다.
        url : "/items",      // 컨트롤러에서 대기중인 URL 주소이다.
        // data : params,            // Json 형식의 데이터이다.
        success : function(data){ // 비동기통신의 성공일경우 success콜백으로 들어옵니다. 'res'는 응답받은 데이터이다.
            // 응답코드 > 0000
            console.log(data);
            $("#babo-data").html("");
            for (var i = 0; i < data.length; i++) {
                $("#babo-data")
                    .append("<tr><td>" + data[i].itemId + "</td>"
                        + "<td>" + data[i].itemName + "</td>"
                        + "<td>" + data[i].itemPrice + "</td>"
                        + "<td>"
                        + "<button onclick=\"deleteItem(" + data[i].itemId +")\">삭 제</button>"
                        + "</td>"
                        + "</tr>");
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){ // 비동기 통신이 실패할경우 error 콜백으로 들어옵니다.
            alert("통신 실패.")
        }
    });
}

$("#babo").click(function(){

    getItemList();
});