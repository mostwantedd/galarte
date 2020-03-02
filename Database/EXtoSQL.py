import xlrd
import MySQLdb

# Open the workbook and define the worksheet
book = xlrd.open_workbook("test DB.xlsx")
sheet_names = book.sheet_names()
for i in range (0,len(sheet_names)):
	sheet = book.sheet_by_name(sheet_names[i])
	# Establish a MySQL connection
	database = MySQLdb.connect (host="localhost", user = "root", passwd = "ip20", db = "ipproject")
	print("connected to the DB")

	# Get the cursor, which is used to traverse the database, line by line
	cursor = database.cursor()

	# Create the INSERT INTO sql query
	if sheet_names[i] == "STYLE":
		query = """INSERT INTO STYLE (name, era, description) VALUES (%s, %s, %s)"""
	elif sheet_names[i] == "AUTHOR":
		query = """INSERT INTO AUTHOR (name, style, born,death,description) VALUES (%s, %s, %s,%s,%s)"""
	elif sheet_names[i] == "ART_PIECE":
		query = """INSERT INTO ART_PIECE (name, author,style,date, description) VALUES (%s, %s, %s,%s,%s)"""
	else :
		query = """INSERT INTO PLACE (name, email,country,city) VALUES (%s, %s, %s,%s)"""

	# Create a For loop to iterate through each row in the XLS file, starting at row 2 to skip the headers
	for r in range(1, sheet.nrows):
		if sheet.cell(r,0).value != "":   #check if the first cell is empty
			name		    = sheet.cell(r,0).value
			if sheet_names[i] == "STYLE":
				era	            = int(sheet.cell(r,1).value)
				description	    = sheet.cell(r,2).value

				values = (name, era, description)

			elif sheet_names[i] == "AUTHOR":
				style 			= sheet.cell(r,1).value
				born 			= sheet.cell(r,2).value
				death 			= sheet.cell(r,3).value
				description 	= sheet.cell(r,4).value

				values = (name, style,born,death, description)

			elif sheet_names[i] == "ART_PIECE":
				author 			= sheet.cell(r,1).value
				style 			= sheet.cell(r,2).value
				date 			= sheet.cell(r,3).value
				description 	= sheet.cell(r,4).value

				values = (name, author,style,date, description)			

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