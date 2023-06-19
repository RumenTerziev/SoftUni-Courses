function solve() {
   document.querySelector('#searchBtn').addEventListener('click', onClick);

   function onClick() {

      const tds = Array.from(document.getElementsByTagName('td'));
      const search = document.getElementById('searchField');
   
      tds.forEach(td => td.parentElement.classList.remove('select'));

      for (const td of tds) {

         if (td.textContent.includes(search.value)) {
            td.parentElement.classList.add('select');
         }
      }

      search.value = '';
   }
}