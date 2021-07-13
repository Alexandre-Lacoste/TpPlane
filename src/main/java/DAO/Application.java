
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import repository.IAdresseRepository;
import repository.IBilletRepository;
import repository.IClientRepository;
import repository.IPassagerRepository;
import repository.IReservationRepository;
import repository.jpa.AdresseRepositoryJpa;
import repository.jpa.BilletRepositoryJpa;
import repository.jpa.ClientRepositoryJpa;
import repository.jpa.PassagerRepositoryJpa;
import repository.jpa.ReservationRepositoryJpa;

public class Application {
	private static Application instance = null;

	private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("formation-jpa");

	private final IClientRepository clientRepo = new ClientRepositoryJpa();
	private final IAdresseRepository adresseRepo = new AdresseRepositoryJpa();
	private final IReservationRepository reservationRepo = new ReservationRepositoryJpa();
	private final IPassagerRepository passagerRepo = new PassagerRepositoryJpa();
	private final IBilletRepository billetRepo = new BilletRepositoryJpa();
	private final IVolRepository volRepo = new VolRepositoryJpa();
	private final IAeroportRepository aeroportRepo = new AeroportRepositoryJpa();
	private final IVilleRepository villeRepo = new VilleRepositoryJpa();
	private final ICompagnieAerienneVolRepository compagnieaeriennevolRepo = new CompagnieAerienneVolRepositoryJpa();
	private final ICompagnieAerienneRepository compagnieaerienneRepo = new CompagnieAerienneRepositoryJpa();
	
	
	public static Application getInstance() {
		return instance;
	}
	public static void setInstance(Application instance) {
		Application.instance = instance;
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public IEntrepriseRepository getEntrepriseRepo() {
		return entrepriseRepo;
	}
	public IParticulierRepository getParticulierRepo() {
		return particulierRepo;
	}
	public IClientRepository getClientRepo() {
		return clientRepo;
	}
	public IAdresseRepository getAdresseRepo() {
		return adresseRepo;
	}
	public IReservationRepository getReservationRepo() {
		return reservationRepo;
	}
	public IPassagerRepository getPassagerRepo() {
		return passagerRepo;
	}
	public IBilletRepository getBilletRepo() {
		return billetRepo;
	}
	public IVolRepository getVolRepo() {
		return volRepo;
	}
	public IAeroportRepository getAeroportRepo() {
		return aeroportRepo;
	}
	public IVilleRepository getVilleRepo() {
		return villeRepo;
	}
	public ICompagnieAerienneVolRepository getCompagnieaeriennevolRepo() {
		return compagnieaeriennevolRepo;
	}
	public ICompagnieAerienneRepository getCompagnieaerienneRepo() {
		return compagnieaerienneRepo;
	}

	
}
