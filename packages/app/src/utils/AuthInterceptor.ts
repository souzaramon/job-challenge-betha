export default function AuthInterceptor ($location: any, $q: any) {
    return {
      request: function(config: any) {
        config.headers = config.headers || {};
  
        if (localStorage.getItem("@app/access_token")) {
          config.headers['Authorization'] = 'Bearer ' + localStorage.getItem("@app/access_token");
        }

        return config;
      },
  
      responseError: function(response: any) {
        if (response.status === 401 || response.status === 403) {
          localStorage.clear();
          $location.path('/auth/signin');
        }
  
        return $q.reject(response);
      }
    }
  }