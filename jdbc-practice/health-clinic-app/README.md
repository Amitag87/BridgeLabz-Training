# Health Clinic Management System - JDBC Application

## Overview
Complete Health Clinic Management System implementing all 6 major use case categories with JDBC and MySQL.

## Database Setup

1. Install MySQL Server
2. Run the schema.sql file:
```bash
mysql -u root -p < sql/schema.sql
```

3. Update database credentials in `DatabaseConnection.java`:
```java
private static final String USER = "your_username";
private static final String PASSWORD = "your_password";
```

## Project Structure
```
health-clinic-app/
├── sql/
│   └── schema.sql                    # Database schema with tables and indexes
├── src/
│   ├── DatabaseConnection.java       # Connection utility
│   ├── PatientManagement.java        # UC-1: Patient CRUD operations
│   ├── DoctorManagement.java         # UC-2: Doctor profile management
│   ├── AppointmentScheduling.java    # UC-3: Appointment booking/scheduling
│   ├── VisitManagement.java          # UC-4: Visit records and prescriptions
│   ├── BillingManagement.java        # UC-5: Billing and payment processing
│   ├── SystemAdministration.java     # UC-6: Admin operations
│   └── HealthClinicApp.java          # Main application
```

## Use Cases Implemented

### 1. Patient Management (UC-1.1 to UC-1.4)
- Register new patient with auto-increment ID
- Update patient information
- Search patients by name/phone/ID using LIKE operator
- View patient visit history with JOIN queries

### 2. Doctor Management (UC-2.1 to UC-2.4)
- Add doctor profile with specialty reference
- Update doctor specialty with transactions
- View doctors by specialty using JOIN
- Deactivate doctor with future appointment check

### 3. Appointment Scheduling (UC-3.1 to UC-3.5)
- Book appointments with availability check
- Check doctor availability with GROUP BY
- Cancel appointments with audit logging
- Reschedule with transaction rollback
- View daily schedule with multi-table JOIN

### 4. Visit Management (UC-4.1 to UC-4.3)
- Record patient visits with transaction
- View medical history ordered by date
- Add prescriptions using batch INSERT

### 5. Billing & Payments (UC-5.1 to UC-5.4)
- Generate bills with SUM calculations
- Record payments with transaction
- View outstanding bills with aggregate functions
- Generate revenue reports with BETWEEN and HAVING

### 6. System Administration (UC-6.1 to UC-6.3)
- Manage specialty lookup with constraint checks
- View database metadata
- View audit logs with timestamp filtering

## Key JDBC Concepts Applied

✓ Primary/Foreign Keys with referential integrity
✓ PreparedStatement for SQL injection prevention
✓ Transactions (COMMIT/ROLLBACK)
✓ INNER/LEFT JOINs for multi-table queries
✓ Aggregate functions (COUNT, SUM, AVG)
✓ Batch operations for bulk inserts
✓ ResultSet navigation and iteration
✓ DatabaseMetaData for schema information
✓ Auto-increment primary keys
✓ Indexes on frequently queried columns

## Compilation & Execution

```bash
# Compile
javac -d bin src/*.java

# Run
java -cp bin:mysql-connector-java.jar HealthClinicApp
```

## Dependencies
- MySQL Connector/J (JDBC Driver)
- MySQL Server 5.7+
- Java 8+

## Sample Workflow

1. Add specialties (Cardiology, Dermatology, etc.)
2. Register doctors with specialties
3. Register patients
4. Book appointments
5. Record visits after appointments
6. Add prescriptions
7. Generate and process bills
8. View reports and audit logs
