
function enviarProBack(formId,url,destination){
    const formEl = document.getElementById(formId);
    formEl.addEventListener('submit', e =>{
    e.preventDefault();

    const formData =  new FormData(formEl);
    const data = Object.fromEntries(formData);

    fetch(url,{
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(data)
    }).then(response => {
        if(response.ok){
            window.location=destination;
        }else if(response.status == 406){

        }

    })
});
}