import { Requester } from 'requester';

export function load(templateName) {

  return Requester.get(`templates/${templateName}.handlebars`)
    .then(template => {
      const compiledTemplate = Handlebars.compile(template);
      return Promise.resolve(compiledTemplate);
    });
}