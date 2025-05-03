
define([], function () {
  'use strict';

  const UTIL_CONSTANTS = {
    message_timeout: 4000,
    serverUrl: 'http://localhost:7101/Schedule/jersey/ScheduleServices/'
  }

  async function callGetService(serviceName) {
    return new Promise(function (resolve, reject) {

      let headers = {};

      headers['Content-Type'] = 'application/json';

      fetch(`${UTIL_CONSTANTS.serverUrl}${serviceName}`, {
        method: 'GET',
        headers,
        mode: 'cors'
      })
        .then(resp => resp.json())
        .then((data) => {
          resolve(data)
        })
        .catch((error) => {
          reject(error);
        });
    });
  }

  async function callPostService(serviceName, data) {
    return new Promise(function (resolve, reject) {

      let headers = {};

      headers['Content-Type'] = 'application/json';

      let body = JSON.stringify(data);

      fetch(`${UTIL_CONSTANTS.serverUrl}${serviceName}`, {
        method: 'POST',
        headers,
        mode: 'cors',
        body
      })
        .then(resp => resp.json())
        .then((data) => {
          resolve(data)
        })
        .catch((error) => {
          reject(error);
        });
    });
  }

  async function callSimplePostService(serviceName, data) {
    return new Promise(function (resolve, reject) {

      let headers = {};

      headers['Content-Type'] = 'application/json';

      let body = JSON.stringify(data);

      fetch(`${UTIL_CONSTANTS.serverUrl}${serviceName}`, {
        method: 'POST',
        headers,
        mode: 'cors',
        body
      })
        .then(resp => resp.text())
        .then((data) => {
          resolve(data)
        })
        .catch((error) => {
          reject(error);
        });
    });
  }
  return {
    callGetService,
    callPostService,
    callSimplePostService,
    UTIL_CONSTANTS
  };
});