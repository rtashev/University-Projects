import 'jquery';
import * as loadTemplate from 'templates';
import * as handlebarsUtils from 'handlebars-utils';
import * as availableAssigmentsData from 'availableAssigments-data';
import * as objCreatorUtil from 'objCreator-utils';
import * as assigmentsData from 'assigments-data';

const $appContainer = $('#app-container');

export function get(){
    //fetches the available assigments page
     Promise.all([loadTemplate.load('available-assigments'), availableAssigmentsData.getAssigments()])
        .then(([template, assigments]) => {
            let user = JSON.parse(localStorage.getItem('user'));
            let templateData = objCreatorUtil.getAssigmentsReqObj(user, assigments);
            $appContainer.html(template(templateData));
    });
    
}

export function deleteAssigment(assigmentId){
    assigmentsData.deleteAssigment(assigmentId)
        .then(() => {
            location.href = '#/availableAssigments';
        });
}

export function takeAssigment(assigmentId){
    let user = JSON.parse(localStorage.getItem('user'));
    let userId = user.user.id;
    
    assigmentsData.takeAssigment(assigmentId, userId)
        .then(() => {
            localStorage.removeItem('user');
            
            let a = user.user;
            a.has_Assigment = true;
            const userData = {user : a};

            localStorage.setItem('user',JSON.stringify(userData));
            
            location.href = '#/availableAssigments';
            
        })
}