import 'jquery';
import * as loadTemplate from 'templates';
import * as handlebarsUtils from 'handlebars-utils';
import * as assigmentsData from 'assigments-data';

const $appContainer = $('#app-container');

export function get(){
    loadTemplate.load('add-assigment').then((template) => {
        let user = JSON.parse(localStorage.getItem('user'));
        $appContainer.html(template(user));
    });
}

export function submitAssigment(){
    let assigmentName = $('#assigment-title').val();
    let assigmentTopic = shortenCategoryName($('#assigment-topic').val());
    let assigmentDescr = $('#assigment-description').val();
    
    assigmentsData.addAssigment(assigmentName, assigmentTopic, assigmentDescr).then((data) => {
        location.href = '#/addAssigment';
//        if(data.isValid){
//            location.href = '#/addAssigment';
//        }else{
//            Promise.reject(new Error('failed')).catch(() => {
//                console.log('caught');
//            })
//        }
    })
}

function shortenCategoryName(longName){
    let shortName = "";
    
    switch(longName){
        case "Virtual Reality (VR)" : shortName = "VR";
            break;
        case "Artifical Inteligence (AI)" : shortName = "AI";
            break;
        case "Computer Graphics (CG)" : shortName = "CG";
            break;
    }
    
    return shortName;
}