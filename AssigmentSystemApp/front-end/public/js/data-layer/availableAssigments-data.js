import { Requester } from 'requester';
import * as loadTemplate from 'templates';

export function getAssigments(){
    return Requester.get('http://localhost:8085/assigment-api/availableAssigments');
}