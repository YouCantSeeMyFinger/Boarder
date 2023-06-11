
// 생략이 가능한 부분이지만 따로 생략은 하지 않는다.
$(document).ready(
    () => {
        // 한 페이지에 15개
        const itemPerPage = 15;
        // tableRows[n] : n>=0
        const tableRows = document.querySelectorAll('.table tbody tr');
        // 총 데이터의 갯수
        const DataNumber = tableRows.length;
        // 총 페이지 개 수
        const totalPages = Math.ceil(DataNumber / itemPerPage);
        // pagination ID선택
        const addpagination = $('#add-pagination');

        // TODO 1. 데이터의 개수 만큼 pagination 생성.
        // TODO LIST Complete
        for (let i = 0; i < totalPages; i++) {
            const pageNumber = i + 1;
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

            // 아래의 이벤트 리스너에서 신기한 동작과정이 있다.
            // 자바에서 실행블록내의 변수를 선언하고 사용 할 시에 해당 블록이 끝날 시 변수가 파괴된다.
            // 하지만 다른 메소드에서 해당 메소드를 불러와서 그 파괴된 변수의 값을 그대로 사용하는 경우가 있는대 이를 클로저 현상이라고 말한다.

            // 아래의 이벤트 리스너에서도 자바 클로저현상과 비슷한 현상이 일어나고 있다.
            // 현재 이벤트 리스너에의해 이벤트가 발생한 객체에 실행 로직을 구현
            // 반복문이 실행되고 pageN

            link.addEventListener('click', () => {
                console.log('pageNumber : ', pageNumber);
                showPage(pageNumber);
            });
        }

        // TODO 각 페이지에 맞게 글 출력
        function showPage(pageNumber) {
            // 시작 페이지에 있는 글의 인덱스
            const startPageTableIndex = (pageNumber - 1) * itemPerPage;
            // 끝 페이지에 있는 글의 인덱스
            const endPagePageTableIndex = startPageTableIndex + itemPerPage;


            // 각 페이지 출력 글 갯수 제한
            // 각 페이지 번호를 사용하여 각페이지 별 글의 인덱스 번호 컨트롤
            for (let i = 0; i < tableRows.length; i++) {
                // 1페이지 : index [0,15)
                // 2페이지 : index [15,30)
                if (i >= startPageTableIndex && i < endPagePageTableIndex) {
                    tableRows[i].style.display = 'table-row';
                } else {
                    tableRows[i].style.display = 'none';
                }
            }
        }

        // Default showPage = 1
        showPage(1);
    }
);
