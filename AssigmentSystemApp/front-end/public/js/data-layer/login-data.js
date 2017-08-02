import { Requester } from 'requester';
import * as loadTemplate from 'templates';

export function login(username, password){
    const body = {
        username,
        password
    };
    
    return Requester.post('http://localhost:8085/assigment-api/auth',body);
}