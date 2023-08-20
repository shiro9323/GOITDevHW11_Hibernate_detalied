import crud.ClientCrudService;
import crud.PlanetCrudService;
import crud.TicketCrudService;
import enity.Client;
import enity.Planet;
import enity.Ticket;
import hibernate.DBInitService;
import hibernate.HibernateUtil;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*new DBInitService().initDB();
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();

        //ClientCRUDService
        System.out.println("\n---ClientCRUDService---\n");

        ClientCrudService clientCrudService = new ClientCrudService(hibernateUtil);

        //create
        Client client = new Client();
        client.setName("clientNEW");
        clientCrudService.create(client);
        System.out.println("Create client id: " + client.getId() + ", name: " + client.getName());

        //getAll
        System.out.println("All Clients: " + clientCrudService.getAll());

        //get
        System.out.println("Get client by id: " + clientCrudService.getById(11));

        //update
        Client updateClientById = clientCrudService.getById(11);
        updateClientById.setName("clientUPDATE");
        clientCrudService.update(updateClientById, 11);
        System.out.println("Update client id: " + client.getId() + ", name: " + client.getName());

        //getAll
        System.out.println("All Clients: " + clientCrudService.getAll());

        //delete
        clientCrudService.deleteById(11);
        System.out.println("Delete client id: " + 11);

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
        System.out.println("Create planet id: " + planet.getId() + ", name: " + planet.getName());

        //getAll
        System.out.println("All Planets: " + planetCrudService.getAll());

        //get
        System.out.println("Get planet by id: " + planetCrudService.getById("SUN"));

        //update
        Planet updatePlanetById = planetCrudService.getById("SUN");
        updatePlanetById.setName("SunNEW");
        planetCrudService.update(updatePlanetById, "SUN");
        System.out.println("Update planet id: " + planet.getId() + ", name: " + planet.getName());

        //getAll
        System.out.println("All Planets: " + planetCrudService.getAll());

        //delete
        planetCrudService.deleteById("SUN");
        System.out.println("Delete planet id: " + "SUN");

        //getAll
        System.out.println("All Planets: " + planetCrudService.getAll());*/


        //TicketCrudService
        new DBInitService().initDB();
        HibernateUtil hibernateUtil = HibernateUtil.getInstance();
        PlanetCrudService planetCrudService = new PlanetCrudService(hibernateUtil);
        System.out.println("\n---TicketCrudService---\n");
        TicketCrudService ticketCrudService = new TicketCrudService(hibernateUtil);

        //ticket to client
        Client clientToTicket = new Client();

        Ticket ticket = new Ticket();
        ticket.setCreatedAt(LocalDateTime.now());
        clientToTicket.setId(1);
        ticket.setClient(clientToTicket);

        ticket.setFromPlanet(planetCrudService.getById("MARS"));
        ticket.setToPlanet(planetCrudService.getById("EAR"));

        //create
        ticketCrudService.create(ticket);
        System.out.println("Create ticket: " + ticket);

        //get
        System.out.println("Get ticket by id: " + ticketCrudService.getById(11));

        //ticket to planet
        Ticket updateTicketById = ticketCrudService.getById(11);
        updateTicketById.setToPlanet(planetCrudService.getById("JUP"));

        //update
        ticketCrudService.update(updateTicketById, 11);
        System.out.println("Update ticket by id: " + ticketCrudService.getById(11));

        //delete
        ticketCrudService.deleteById(4);

        //getAll
        System.out.println("All Tickets: " + ticketCrudService.getAll());

    }
}
