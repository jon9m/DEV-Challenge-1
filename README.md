	Database setup		-
		run scripts in sql-scripts folder to create user and schema and insert data
			01-create-user.sql
			02-currency_exchange.sql			
		
		Edit resources/persistence-mysql.properties to update jdbc.url to point to the correct database	
		
		
	Build API (.war) 	- 	
		Install Maven 
			compile and build war		 -	mvn compile war:war
			deploy .war file in a web container
	
	
	