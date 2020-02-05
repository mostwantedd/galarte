import xlrd
import MySQLdb

# Open the workbook and define the worksheet
book = xlrd.open_workbook("test DB.xlsx")
sheet_names = book.sheet_names()
sheet = book.sheet_by_name(sheet_names[0])
# Establish a MySQL connection
database = MySQLdb.connect (host="localhost", user = "root", passwd = "ip20", db = "ipproject")
print("connected to the DB")

# Get the cursor, which is used to traverse the database, line by line
cursor = database.cursor()

# Create the INSERT INTO sql query
query = """INSERT INTO STYLE (name, era, description) VALUES (%s, %s, %s)"""

# Create a For loop to iterate through each row in the XLS file, starting at row 2 to skip the headers
for r in range(1, sheet.nrows):
	if sheet.cell(r,0).value != "":   #check if the first cell is empty
		name		    = sheet.cell(r,0).value
		era	            = int(sheet.cell(r,1).value)
		description	    = sheet.cell(r,2).value

		# Assign values from each row
		values = (name, era, description)

		# Execute sql Query
		cursor.execute(query, values)

# Close the cursor
cursor.close()

# Commit the transaction
database.commit()

# Close the database connection
database.close()

# Print results
print("done")