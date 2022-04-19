Serves endpoints:
* Doctors
  * GET: /api/doctors - Returns list of all doctors. 
  * GET: /api/doctors/{id} - Returns doctor specified by id.
  * POST: /api/doctors/{id} - Accepts JSON, maps it to a Doctor Object and then saves it to the DB.
  * PUT: /api/doctors/{id} - Accepts JSON, maps it to a Doctor object and then updates doctor specified by id.
  * DELETE: /api/doctors/{id} - Deletes doctor specified by id.
  * GET: /api/doctors/ui - Simple UI using Thymeleaf which displays the doctors.
  * GET: /api/doctors/specialty?spec={spec} - Returns list of doctors having specialty spec.
  * GET: /api/doctors/specialty/{spec} - Returns list of doctors having specialty spec.

* Patients
  * GET: /api/patients - Returns list of all patients.
  * GET: /api/patients/{id} - Returns patient specified by id.
  * POST: /api/patients/{id} - Accepts JSON, maps it to a Patient Object and then saves it to the DB.
  * PUT: /api/patients/{id} - Accepts JSON, maps it to a Patient object and then updates doctor specified by id.
  * DELETE: /api/patients/{id} - Deletes patient specified by id.
  * GET: /api/patients/ui - Simple UI using Thymeleaf which displays the patients.

* Appointments (Many-to-one relationship with doctor and patient)
  * GET: /api/appointments - Returns list of all appointments.
  * GET: /api/appointments/{id} - Returns appointment specified by id.
  * POST: /api/appointments/ - Posts a JSON object of type AppointmentRequestBody which includes the id of a doctor, the id of a patient, the appointment's datetime and description and initializes a new instance of appointment between those entities.
  * DELETE: /api/appointments/{id} - Deletes appointment specified by id.
  * GET: /api/appointments/ui - Simple UI using Thymeleaf which displays the appointments.