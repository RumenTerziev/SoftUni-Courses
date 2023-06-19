function create(words) {
   
   const divContent = document.getElementById('content');
   for (const word of words) {
      let div = document.createElement('div');
      let paragraph = document.createElement('p');


      paragraph.textContent = word;
      paragraph.style.display = 'none';
      div.appendChild(paragraph);
      div.addEventListener('click', eventHandler);
      divContent.appendChild(div);

   }

   function eventHandler() {
      let paragraph = Array.from(this.children)[0];
      paragraph.style.display = 'block';
   }  

}