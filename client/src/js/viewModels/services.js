
define([
  "require",
  "exports",
  "knockout",
  "ojs/ojbootstrap",
  "ojs/ojarraydataprovider",
  "utils",
  "ojs/ojtable",
  "ojs/ojknockout",
  "ojs/ojbutton",
  "ojs/ojdialog",
  "ojs/ojmessages",
  "ojs/ojinputtext",
  "ojs/ojavatar"],
  function (require, exports, ko, ojbootstrap_1, ArrayDataProvider, utils) {

    function ServicesViewModel() {

      this.serviceArray = ko.observableArray([]);
      this.messagesDataprovider = ko.observableArray([]);
      this.serviceName = ko.observable('');
      this.serviceDesc = ko.observable('');
      this.serviceNameUpdate = ko.observable('');
      this.serviceDescUpdate = ko.observable('');
      this.deleteServiceName = ko.observable('');

      const self = this;


      this.getData = () => {
        utils.callGetService('getServices')
          .then(
            (response) => {
              if (response.servicesTableInputs)
                this.serviceArray(response.servicesTableInputs);
            }
          )
          .catch((err) => {
            console.log("Error while calling service");
          });
      }

      this.getData()

      this.dataprovider = new ArrayDataProvider(this.serviceArray ?? [], {
        keyAttributes: 'serviceName',
        implicitSort: [{ attribute: 'serviceName', direction: 'ascending' }]
      });



      this.cancel = function () {
        document.getElementById("modalDialog1").close();
      }

      this.cancelDelete = function () {
        document.getElementById("deleteServiceDialogId").close();
      }

      this.save = function () {

        console.log({ name: self.serviceName(), desc: self.serviceDesc() });

        if (self.serviceName() == '' || self.serviceDesc() == '') {
          self.messagesDataprovider.push(
            {
              severity: 'error',
              summary: 'Error',
              detail: 'Enter valid values for name and description',
              autoTimeout: utils.UTIL_CONSTANTS.message_timeout
            }
          );
        } else {


          const data = {
            serviceName: self.serviceName(),
            serviceDescription: self.serviceDesc(),
          }

          utils.callSimplePostService('insertService', data)
            .then(
              (response) => {
                if (response === 'Y') {
                  document.getElementById("modalDialog1").close();

                  self.messagesDataprovider.push(
                    {
                      severity: 'confirmation',
                      summary: 'New Service',
                      detail: 'New service added successfully',
                      autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                    }
                  );

                  self.getData();
                } else {
                  self.messagesDataprovider.push(
                    {
                      severity: 'error',
                      summary: 'Error',
                      detail: 'Error inserting new service',
                      autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                    }
                  );
                }
              }
            )
            .catch((err) => {

              self.messagesDataprovider.push(
                {
                  severity: 'error',
                  summary: 'Error',
                  detail: 'Something went wrong',
                  autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                }
              );
              console.log("Error while calling service");
            });
        }

      }

      this.deleteService = function () {

        console.log({ name: self.deleteServiceName() });

          const data = {
            serviceName: self.deleteServiceName(),
          }

          utils.callSimplePostService('deleteService', data)
            .then(
              (response) => {
                if (response === 'Y') {
                  document.getElementById("deletServiceDialog1").close();

                  self.messagesDataprovider.push(
                    {
                      severity: 'confirmation',
                      summary: 'Delete Service',
                      detail: 'Service deleted successfully',
                      autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                    }
                  );

                  self.getData();
                } else {
                  self.messagesDataprovider.push(
                    {
                      severity: 'error',
                      summary: 'Error',
                      detail: 'Error while deleting new service',
                      autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                    }
                  );
                }
              }
            )
            .catch((err) => {

              self.messagesDataprovider.push(
                {
                  severity: 'error',
                  summary: 'Error',
                  detail: 'Something went wrong',
                  autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                }
              );
              console.log("Error while calling service");
            });
      }
      
      this.cancelUpdate = function () {
        document.getElementById("updateServiceDialogId").close();
      }

      this.cancelDelete = function () {
        document.getElementById("deleteServiceDialogId").close();
      }

      this.saveUpdate = function () {

        console.log({ name: self.serviceNameUpdate(), desc: self.serviceDescUpdate() });

        if (self.serviceNameUpdate() == '' || self.serviceDescUpdate() == '') {
          self.messagesDataprovider.push(
            {
              severity: 'error',
              summary: 'Error',
              detail: 'Enter valid values for name and description',
              autoTimeout: utils.UTIL_CONSTANTS.message_timeout
            }
          );
        } else {


          const data = {
            serviceName: self.serviceNameUpdate(),
            serviceDescription: self.serviceDescUpdate(),
          }

          utils.callSimplePostService('updateService', data)
            .then(
              (response) => {
                if (response === 'Y') {
                  document.getElementById("updateServiceDialogId").close();

                  self.messagesDataprovider.push(
                    {
                      severity: 'confirmation',
                      summary: 'Update Service',
                      detail: 'Service updated successfully',
                      autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                    }
                  );

                  self.getData();
                } else {
                  self.messagesDataprovider.push(
                    {
                      severity: 'error',
                      summary: 'Error',
                      detail: 'Error updating service',
                      autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                    }
                  );
                }
              }
            )
            .catch((err) => {

              self.messagesDataprovider.push(
                {
                  severity: 'error',
                  summary: 'Error',
                  detail: 'Something went wrong',
                  autoTimeout: utils.UTIL_CONSTANTS.message_timeout
                }
              );
              console.log("Error while calling service");
            });
        }

      }
      this.open = function () {
        self.serviceName('');
        self.serviceDesc('');

        document.getElementById("modalDialog1").open();
      }
      this.openUpdate = function () {
        self.serviceNameUpdate('');
        self.serviceDescUpdate('');

        document.getElementById("updateServiceDialogId").open();
      }

      this.openDelete = function () {
        document.getElementById("deleteServiceDialogId").open();
      }

      this.selectedChangedListener = (event) => {

        const row = event.detail.value.row;
        if (row.values().size > 0) {
          row.values().forEach(function (key) {

            console.log("Selected key: " + key)

            let selectedRow = self.serviceArray().find(s => s.serviceName === key);

            console.log("Selected row: " + selectedRow);
            self.serviceNameUpdate(key);
            self.deleteServiceName(key);
            self.serviceDescUpdate(selectedRow.serviceDescription);

          });
        }
      };

    }



    /*
     * Returns an instance of the ViewModel providing one instance of the ViewModel. If needed,
     * return a constructor for the ViewModel so that the ViewModel is constructed
     * each time the view is displayed.
     */
    return ServicesViewModel;
  }
);
