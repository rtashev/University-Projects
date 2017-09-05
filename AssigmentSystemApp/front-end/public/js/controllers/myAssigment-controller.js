import 'jquery';
import * as loadTemplate from 'templates';
import * as handlebarsUtils from 'handlebars-utils';
import * as assigmentsData from 'assigments-data';
import * as objCreatorUtil from 'objCreator-utils';

const $appContainer = $('#app-container');

export function get(){
    
    let userAssigment = null;
    const user = JSON.parse(localStorage.getItem('user'));
    const userId = user.user.id;
    
    assigmentsData.getMyAssigment(userId).then((data) => {
        if(!user.user.has_Assigment){
            throw new Error('user has no assigment');
        }
        
        userAssigment = data;
        if(userAssigment.isSubmitted){
            loadTemplate.load('my-assigment-submitted').then((template) => {
                $appContainer.html(template(user));
            });
        }else{
            loadTemplate.load('my-assigment').then((template) => {
                const templateData = objCreatorUtil.getMyAssigmentReqObj(user, userAssigment);
                $appContainer.html(template(templateData));
            });
        }
               
    }).catch(() => {
        loadTemplate.load('my-assigment-nodata').then((template) => {
            $appContainer.html(template(user));
        })
    });

}

export function submitAssigment(){
    let fileInput = document.getElementById('file-input');
    let file = fileInput.files[0];
    let formData = new FormData();
    formData.append('file', file);
    let assigmentId = $('#assigment-id').text();
    
    assigmentsData.submitMyAssigment(assigmentId, formData).then((data) => {
        console.log(data);
        location.href = '#/home';
    });
}