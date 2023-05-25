$('.menubar li').hover(
    () => {
        $('ul', event.currentTarget).stop().slideDown(200);
    },
    () => {
        $('ul', event.currentTarget).stop().slideUp(200);
    }
);

// Arrow function 방법


