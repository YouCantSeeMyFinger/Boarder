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
                    const memberBar = $('.js-login-custom');

                    // class : '.member-bar' html 초기화
                    memberBar.empty();

                    const loginHTML = `
                        <div class="d-flex justify-content-center align-items-center col-6">
                            <a class="nav-link active text-white" aria-current="page">"${userName}"님</a>
                        </div>
                           
                        <span class="text-white ml-2 mr-2">|</span>
                        
                      <li class="nav-item dropdown d-flex justify-content-center align-items-center col">
                      
                             <a class="nav-link dropdown-toggle text-white" href="#" role="button" data-bs-toggle="dropdown"
                                aria-expanded="false">
                                INFO
                             </a>
                         
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#" th:href="@{/freeBoarder}">로그아웃</a></li>
                                <hr>
                                <li><a class="dropdown-item" href="#" th:href="@{/phothBoarder}">글 목록</a></li>
                                <hr>
                                <li><a class="dropdown-item" href="#" th:href="@{/marketBoarder}">내 정보</a></li>
                            </ul>
                      </li>
                    `;

                    memberBar.append(loginHTML);

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

/**
 *
 *                     const loginMemberHtml =
 *                         `<li class="login">
 *                             <a>${userName}님 환영합니다.</a>
 *                          </li>
 *
 *                          <li class="downarrow-box">
 *                             <a><i class="fa fa-chevron-down"></i></a>
 *                             <ul class="arrow-sub-menu-box">
 *                                 <li><a href="/mypage">My Page</a></li>
 *                                 <li><a href="/logout">LogOut</a></li>
 *                             </ul>
 *                          </li>`;
 *
 *                     memberBar.append(loginMemberHtml);
 *
 *                     $('.downarrow-box').hover(() => {
 *                         $(this).find('.arrow-sub-menu-box').slideToggle(200);
 *                     });
 */


