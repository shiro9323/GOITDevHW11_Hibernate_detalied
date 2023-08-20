import crud.ClientCrudService;
import crud.PlanetCrudService;
import enity.Client;
import enity.Planet;
import hibernate.DBInitService;
import hibernate.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        new DBInitService().initDB();
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();

        //ClientCRUDService
        System.out.println("\n---ClientCRUDService---\n");

        ClientCrudService clientCrudService = new ClientCrudService(hibernateUtil);

        //create
        Client client = new Client();
        client.setName("clientNEW");
        clientCrudService.create(client);

        //getAll
        System.out.println("All Clients: " + clientCrudService.getAll());

        //get
        System.out.println("Get client by id: " + clientCrudService.getById(11));

        //update
        Client updateClientById = clientCrudService.getById(11);
        updateClientById.setName("clientUPDATE");
        clientCrudService.update(updateClientById, 11);

        //getAll
        System.out.println("All Clients: " + clientCrudService.getAll());

        //delete
        clientCrudService.deleteById(11);

        //getAll
        List<Client> allClients = clientCrudService.getAll();
        System.out.println("All Clients: " + allClients);


        //PlanetCRUDService
        System.out.println("\n---PlanetCRUDService---\n");

        PlanetCrudService planetCrudService = new PlanetCrudService(hibernateUtil);

        //create
        Planet planet = new Planet();
        planet.setId("SUN");
        planet.setName("Sun");
        planetCrudService.create(planet);

        //getAll
        System.out.println("All Planets: " + planetCrudService.getAll());

        //get
        System.out.println("Get planet by id: " + planetCrudService.getById("SUN"));

        //update
        Planet updatePlanetById = planetCrudService.getById("SUN");
        updatePlanetById.setName("SunNEW");
        planetCrudService.update(updatePlanetById, "SUN");

        //getAll
        System.out.println("All Planets: " + planetCrudService.getAll());

        //delete
        planetCrudService.deleteById("SUN");

        //getAll
        System.out.println("All Planets: " + planetCrudService.getAll());


    }
}
