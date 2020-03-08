package com.navin;


import com.navin.entity.Instructor;
import com.navin.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructionDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();

			// get instructor by primary key / id
			int theId = 2;
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			// delete the instructors
			if (tempInstructorDetail != null) {
			
				System.out.println("InstructorDetail: " + tempInstructorDetail);
				if(tempInstructorDetail.getInstructor() != null){
					System.out.println("Instructor: " + tempInstructorDetail.getInstructor());
				}
			}
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





