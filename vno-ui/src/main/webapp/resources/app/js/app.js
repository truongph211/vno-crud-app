(function() {
    var app = angular.module('myApp', []);
    var getUrl = () => {
        return window.location.origin + "/cxf/api/vnos";
    }

    var urlBase = getUrl();
    app.factory("Post", function($resource) {
	    return $resource(urlBase);
    });

    app.controller('VnoController', function($scope, $http) {

        $scope.vno = {};
        $scope.vnos = [];

    	$scope.reload = () => {
            $http.get(urlBase)
            .then(function(response) {
                  $scope.vnos = response.data
                  console.log($scope.vnos)
              });
         };

         $scope.updateData = () => {
             $http({
                url: urlBase + "/" + $scope.vno.id,
                method: 'PUT',
                data: $scope.vno,
                headers: {'Content-Type': 'application/json'}
            }).then(function success(response) {
                console.log(response);
            }, function fail(error) {
                console.log(error);
            })

        };

 //Create New Vno
      $scope.addData = () => {
        //POST function
        var vno = JSON.stringify($scope.vno);
        $http({
          method:'POST',
          url: urlBase,
          headers: {
              'Content-Type': 'application/json'
          },
          data: vno
        }).then(function success(response) {
//          $scope.vnos.push(response.data);
          console.log(response.data)
          $scope.reload();
//          alert("Vno has created Successfully")

        }, function fail(error) {
          alert(error.data);
        });

      };


        $scope.delete = (id) => {
            $http.delete(urlBase + "/" + id)
                .success(function (response) {
                    $scope.reload();
                });
            $scope.vno = {};
        }

        $scope.select = function(id) {
            $scope.vno = $scope.vnos[id];
        }
// Find item
    function findById(id) {
            let found = {};
            for(const key in $scope.vnos) {
                if($scope.vnos[key].id === id) {
                    found = $scope.vnos[key];
                    break;
                }
            }
            return found;
        }


        // init
        $scope.reload();

    });
})();
