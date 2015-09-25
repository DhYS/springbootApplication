This program "realestate.war" contains an example csv file from salesforce. In order to load the file, name it to "report.csv". (For further implementation, eg: loading file via website and loading from salesforce will be in next update)

The program does not contain the search and filter methods, they are finished coding, too lazy and limited time to implement.

Some fix: index fix, picture render, mobile support, SQL support (IMPORTANT), UI rebuild, etc
are in future updates if needed.

As said, this is a web based application

How to run:
1. make sure the "report.csv" is in the same directory as "realestate.war"
2. make sure java is installed and updated
3. for windows: run cmd, cd to program directory
	type: java -jar realestate.war
   a terminal will run with information and logs, until see
   "load completed" and "ready to go" the initialization is done

4. open your browser (ie, firefox, chrome, etc)
	type: localhost:8000
5. welcome to home page


Source code can found here:
https://github.com/chrisyly/springbootApplication.git

If have any question, please email to lying0401@gmail.com 
Also if any request, feel free to contact me. Time to make projects like this is about two days

Here is an example if report.csv not found: (creat a report.csv file and copy into)

"Property: Property Name,City,County,State,Zip",Bedrooms,Bathrooms,Square Feet,Year Built,Neighborhoods,Neighborhood Rating,Status,Purchase Price,Projected CapEx,Total Costs,Price/SF,Projected Rent,Projected Gross Yield
TX,76036",4,2.5,2592,2005,Crowley,Good,Declined to submit offer,,13000,159375,0,1600,12.6
"6211 Berlinetta Drive,Arlington,Tarrant,TX,76001",3,2,1439,1985,Arlington,Above Average,Evaluated,,1500,141860,0,1350,12.1
"a0BG000000l4X9K,,,CA,",,,,,,No Neighborhood,In Research,,15000,15000,#Error!,0,0
"1005 Chamblee Court,Arlington,Tarrant,TX,76014",3,2,1558,1971,Arlington,Above Average,Offer Written/Waiting for Signature,,30000,133125,0,1350,12.7
"897 Hemingway Road,,,CA,",,,,,,No Neighborhood,In Research,,15000,15000,#Error!,0,0
"1718 Foxlake Drive,Houston,Harris,TX,77084",3,2,1568,1984,Katy- North,Above Average,Cancelled,,12000,120975,0,1300,13.1
"7524 MOUNTAIN BLVD,OAKLAND,ALAMEDA,CA,94605",2,1.5,1016,1972,,No Neighborhood,In Research,,15000,15000,0,0,0
"10041 Queens Road,Frisco,Collin County,TX,75035",3,2,1570,1997,Frisco,Best,Evaluated,,15000,189600,0,1725,11.7
"7219 Pheasant Ct,Sachse,Dallas,TX,75048",3,3,2698,2001,Sachse,Best,In Research,,20000,34950,0,1350,6.8
"326 PINOLE AVE,RODEO,CONTRA COSTA,CA,94572",3,2,1515,1978,,No Neighborhood,In Research,,15000,15000,0,0,0
