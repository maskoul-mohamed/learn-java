import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CreateEmployee {

	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.
				createEntityManagerFactory( "ORM_JPA" );
		EntityManager entitymanager = emfactory.
				createEntityManager( );
		entitymanager.getTransaction( ).begin( );
		
		Employee employee = new Employee( ); 
		employee.setEid( 1201 );
		employee.setEname( "Gopal" );
		employee.setSalary( 40000 );
		employee.setDeg( "Technical Manager" );
		entitymanager.persist( employee );
		entitymanager.getTransaction( ).commit( );
		
		entitymanager.close( );
		emfactory.close();

	}

}
