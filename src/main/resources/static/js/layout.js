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

// Contact Us라는 태그를 눌렀을 시 경고창이 발생 후 개발자 연락처 생성
$(document).ready(() => {
    $("a:contains('Contact Us')").click(() => {
        alert("개발자 : 신원균\n" +
            "연락처 : 010- 3712 - 6634");
    });
});



