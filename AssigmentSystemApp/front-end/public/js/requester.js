class Requester{
    
    static request(url, type, body, headers){
        const promise = new Promise((resolve, reject) => $.ajax({
            url,
            type,
            contentType: 'application/json',
            headers,
            data : body,
            success : resolve,
            error : reject,
        }));
        
        return promise;
    }
    
    static get(url, headers = {}){
        return Requester.request(url, 'GET', '', headers);
    }
    
    static post(url, body, headers = {}){
        return Requester.request(url, 'POST', JSON.stringify(body), headers);
    }
    
    static put(url, body, headers = {}){
        return Requester.request(url, 'PUT', JSON.stringify(body), headers);
    }
    
    static postFile(url, body, headers){
        const promise = new Promise((resolve, reject) => $.ajax({
            url,
            type : 'POST',
//            contentType: //'multipart/form-data',
            async: false,
            cache: false,
            contentType: false,
            data : body,
            processData: false, // https://stackoverflow.com/questions/10324594/jquery-illegal-invocation ->Answer by Justo
            success : resolve,
            error : reject,
        }));
        
        return promise;
    }
    
}

export { Requester };