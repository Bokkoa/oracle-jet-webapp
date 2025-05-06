
define([
  "require",
  "exports",
  "knockout",
  "ojs/ojbootstrap",
  "ojs/ojpagingdataproviderview",
  "ojs/ojarraydataprovider",
  "ojs/ojknockout",
  "ojs/ojtable",
  "ojs/ojpagingcontrol",
  "utils",
  "ojs/ojbutton",
  "ojs/ojdialog",
  "ojs/ojmessages",
  "ojs/ojinputtext",
  "ojs/ojavatar"],
  function (require, exports, ko, ojbootstrap_1, PagingDataProviderView, ArrayDataProvider, utils) {
    function UsersViewModel() {


      this.usersArray = ko.observableArray([]);


      this.username = ko.observable('');
      this.userPassword = ko.observable('');
      this.userDisplayName = ko.observable('');
      this.userType = ko.observable('');
      this.userActive = ko.observable('');

      var self = this;

      
      this.getData = () => {
        utils.callGetService('getUsers')
          .then(
            (response) => {
              if (response.userTableInputs)
                self.usersArray(response.userTableInputs);
            }
          )
          .catch((err) => {
            console.log("Error while calling service");
          });
      }

      this.getData()


      this.open = function () {
        document.getElementById("modalDialog1").open();
      }
      this.cancel = function () {
        document.getElementById("modalDialog1").close();
      }
      this.save = function () {

      }

      this.pagingDataProvider = new PagingDataProviderView(new ArrayDataProvider(self.usersArray ?? [], {
        keyAttributes: 'userName'
      }));

    }

    return UsersViewModel;
  }
);
