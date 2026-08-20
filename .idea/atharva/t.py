faculty = []

while True:
    print("\n--- Faculty Management System ---")
    print("1. Add Faculty")
    print("2. View Faculty")
    print("3. Search Faculty")
    print("4. Delete Faculty")
    print("5. Exit")

    choice = input("Enter choice: ")

    if choice == "1":
        name = input("Enter faculty name: ")
        subject = input("Enter subject: ")
        faculty.append([name, subject])
        print("Faculty added successfully!")

    elif choice == "2":
        print("\nFaculty List:")
        for f in faculty:
            print("Name:", f[0], "| Subject:", f[1])

    elif choice == "3":
        name = input("Enter faculty name: ")
        found = False

        for f in faculty:
            if f[0].lower() == name.lower():
                print("Name:", f[0], "| Subject:", f[1])
                found = True

        if not found:
            print("Faculty not found.")

    elif choice == "4":
        name = input("Enter faculty name: ")

        for f in faculty:
            if f[0].lower() == name.lower():
                faculty.remove(f)
                print("Faculty deleted!")
                break
        else:
            print("Faculty not found.")

    elif choice == "5":
        print("Thank you!")
        break

    else:
        print("Invalid choice!")