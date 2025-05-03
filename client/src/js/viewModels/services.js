
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
  "ojs/ojinputtext"],
  function (require, exports, ko, ojbootstrap_1, ArrayDataProvider, utils) {

    function ServicesViewModel() {

      this.serviceArray = ko.observableArray([]);
      this.messagesDataprovider = ko.observableArray([]);
      this.serviceName = ko.observable('');
      this.serviceDesc = ko.observable('');
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
      this.open = function () {
        self.serviceName('');
        self.serviceDesc('');

        document.getElementById("modalDialog1").open();
      }

    }



    /*
     * Returns an instance of the ViewModel providing one instance of the ViewModel. If needed,
     * return a constructor for the ViewModel so that the ViewModel is constructed
     * each time the view is displayed.
     */
    return ServicesViewModel;
  }
);
