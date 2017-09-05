import { Requester } from 'requester';
import * as loadTemplate from 'templates';

export function getData(){
    return Requester.get('http://localhost:8085/assigment-api/assigments');
}

export function addAssigment(assigmentTitle, assigmentTopic, assigmentDescr){
    const body = {
        assigmentTitle,
        assigmentTopic,
        assigmentDescr
    };
    
    return Requester.post('http://localhost:8085/assigment-api/submitAssigment', body);
}

export function getMyAssigment(userId){
    const queryString = 'http://localhost:8085/assigment-api/myAssigment/' + userId;
    return Requester.get(queryString);
}

export function submitMyAssigment(assigmentId, data){
    const url = 'http://localhost:8085/assigment-api/submitMyAssigment/' + assigmentId;
    return Requester.postFile(url, data);
}

export function deleteAssigment(assigmentId){
    const queryString = 'http://localhost:8085/assigment-api/deleteAssigment/' + assigmentId;
    return Requester.post(queryString, null);
}

export function takeAssigment(assigmentId, userId){
    const queryString = 'http://localhost:8085/assigment-api/takeAssigment/' + assigmentId +'/' + userId;
    return Requester.post(queryString, null);
}

export function downloadAssigment(assigmentId){
    const queryString = 'http://localhost:8085/assigment-api/downloadAssigment/' + assigmentId;
    console.log(queryString);
    return Requester.get(queryString);
}