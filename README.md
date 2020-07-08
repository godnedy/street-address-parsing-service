# Street address parsing service

Addresses to be parsed can be passed by calling endpoint specified below.

## Endpoints ##
 
  -----------
  *Parses given addresses*
   ----
     
  * **Endpoint**
  
    /api/address
  
  * **Method:**
  
    `POST`
    
  *  **Path Params**
  
        None
  
  * **Body**
  
  
       [
       "address to be parsed"
       ]
   
  * **Success Response:**
  
    * **Code:** 200 <br />
    
   * **Example call:**
   
        ```
      curl --location --request POST 'http://localhost:8080/api/address' \
      --header 'Content-Type: application/json' \
      --data-raw '
          [
             "Unter den Linden 12" 
          ]
      '
      
      
   **Content:** 
       
          {
              "parsedAddresses": {
                  "Unter den Linden 12": {
                      "street": "Unter den Linden",
                      "housenumber": "12"
                  }
              }
          }