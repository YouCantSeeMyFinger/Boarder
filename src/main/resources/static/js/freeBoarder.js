$(document).ready(
    () => {
        // 한 페이지에 15개
        const itemPerPage = 15;

        // tableRows[n] : n>=0
        const tableRows = document.querySelectorAll('.table tbody tr');

        // 총 데이터의 갯수
        const DataNumber = tableRows.length;

        // if문에서 사용 할 목적이 있어서 만들어 놓았다.
        // 참고로 ceil을 사용하나 이유는 0값을 다루기가 까다롭기 때문이다.
        const totalPages = Math.ceil(DataNumber / itemPerPage);

        // pagination ID선택
        const addpagination = $('#add-pagination');
        // const addpagination = document.querySelector('#add-pagination');

        // 기존의 pagination은 1개 만들어야할 pagination은 -1개
        const createPagination = totalPages - 1;


        // 동작확인 로그
        console.log('tableRows :', tableRows.length);
        console.log('itemPerPage :', itemPerPage);
        console.log('totalPages :', totalPages);

        // TODO 1. 데이터의 개수 만큼 pagination 생성
        for (let i = 0; i < createPagination; i++) {
            const pageNumber = i + 2;
            const listItem = document.createElement('li');
            const link = document.createElement('a');

            // 클래스 생성
            listItem.classList.add('page-item');
            link.classList.add('page-link', 'text-black');

            // 링크 설정
            link.href = '#' + pageNumber;

            // texcContent 설정 <a>[TextContent]</>
            link.textContent = pageNumber.toString();

            listItem.appendChild(link);

            addpagination.append(listItem);
        }


        for (let i = 0; i < tableRows.length; i++) {
            if (i + 1 <= itemPerPage) {
                // 15개까지는 출력
                tableRows[i].style.display = 'table-row';
            } else {
                // 15초과는 미출력
                tableRows[i].style.display = 'none';
            }
        }
    }
);
