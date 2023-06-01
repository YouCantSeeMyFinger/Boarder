$(document).ready(
    function showPage(pageNum) {
        // 한 페이지에 15개
        const itemPerPage = 15;
        // tableRows[n] : n>=0
        let tableRows = document.querySelectorAll('.table tbody tr');
        // if문에서 사용 할 목적이 있어서 만들어 놓았다.
        let totalPages = Math.ceil(tableRows / itemPerPage);

        // 동작확인 로그
        // 선택 갯수
        console.log('tableRows : ', tableRows.length);
        // 첫번째 요소 text 출력
        console.log('tableRows first elements :', tableRows[0].textContent);

        let pagination = document.querySelector('.pagination');


        // pageNavigation 설정
        if (totalPages === 0) {
            // 만약 글이 15개 미만 이라면 pagination이 출력 될 필요가 없다.
            pagination.style.display = 'none';
        } else {
            // TODO 이후 로직 처리
        }
    }
);
