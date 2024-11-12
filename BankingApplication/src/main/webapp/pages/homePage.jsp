<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin: 50px;
        }
        .button-container {
            display: flex;
            flex-direction: column;
            gap: 20px;
            max-width: 300px;
            margin: auto;
        }
        button {
            padding: 15px 30px;
            font-size: 16px;
            cursor: pointer;
            border: none;
            border-radius: 5px;
            background-color: #007BFF;
            color: white;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>User Dashboard</h1>
    <h6>you have to put account id in url manually</h6>
    <div class="button-container">
   
    <form action="/transactions/allTransaction/{AccountId}" method="get">
    <input type="hidden" name="accountId"> <!-- Account ID set here -->
    <button type="submit">Transaction History</button>
    </form>
    
        <form action="/users/getUser/{id}" method="get">
        <input type="hidden" name="id"> <!-- Account ID set here -->
        <button type="submit">Info</button>
        </form>
        
         <form action="/users/editUser/{id}"  >
        <input type="hidden" name="id"> <!-- Account ID set here -->
        <button type="submit">Update Profile</button>
        </form>
        <form action="/operationPerform"  >
        <input type="hidden" name="id"> <!-- Account ID set here -->
        <button type="submit">Operation Perform	</button>
        </form>
       
    </div>
</body>
</html>
