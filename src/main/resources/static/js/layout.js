$('.menubar li').hover(
    // mouse over
    () => {
        $('ul', event.currentTarget).stop().slideDown(200);
    },
    // mouse out
    () => {
        $('ul', event.currentTarget).stop().slideUp(200);
    }
);


$(document).ready(() => {
    $("a:contains('Contact Us')").click(() => {
        alert("개발자 : 신원균\n" +
            "연락처 : 010- 3712 - 6634");
    });
});

// 세션정보를 가져오는 JavaScript
$(document).ready(
    function () {
        $.ajax({
            url: '/get-session',
            type: 'GET',
            dataType: 'json',
            success: (data) => {

                if (data) {
                    const loginMember = data;

                    /**
                     * 주의
                     * 현재 JSON 형식으로 DATA는 이와 같이 정의되어있다.
                     * JSON DATA 형식을 아래에서 가져다 사용할시에 대소문자 구분에 주의하자.
                     * {
                     *     "id":"TEST01",
                     *     "password":"TEST",
                     *     "userName": "신원균"
                     * }
                     */

                    console.log('memberId : ', loginMember.id);
                    console.log('memberUsername : ', loginMember.userName);

                    const id = loginMember.id;
                    const userName = loginMember.userName;

                    // class select
                    const memberBar = $('.member-bar');

                    // class : '.member-bar' html 초기화
                    memberBar.empty();

                    const loginMemberHtml =
                        `<li class="login">
                            <a>${userName}님 환영합니다.</a>
                         </li>
                         
                         <li class="downarrow-box">
                            <a><i class="fa fa-chevron-down"></i></a>
                            <ul class="arrow-sub-menu-box">
                                <li><a href="/mypage">My Page</a></li>    
                                <li><a href="/logout">LogOut</a></li>    
                            </ul>
                         </li>`;

                    memberBar.append(loginMemberHtml);

                    $('.downarrow-box').hover(() => {
                        $(this).find('.arrow-sub-menu-box').slideToggle(200);
                    });

                } else {
                    console.log('세션 정보 없음');
                }
            },
            error: () => {
                console.log('세션 정보를 가져오는대 실패했습니다.')
            }
        });
    }
);


