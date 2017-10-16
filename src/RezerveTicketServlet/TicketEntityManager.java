package RezerveTicketServlet;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TicketEntityManager {

	// ______________________add___________________________
	public int save(Ticket ticket) {
		Session session = HibernateUtil.getSessionFactory().openSession();
			
		Transaction tx = session.beginTransaction();
		addTicket(session, ticket);
		tx.commit();
		session.close();
		int status = 1;
		return status;

	}

	private void addTicket(Session session, Ticket t) {
		Ticket ticket = new Ticket();
		ticket.setDate(t.getDate());
		ticket.setFlightNumber(t.getFlightNumber());
		ticket.setFrom(t.getFrom());
		ticket.setId(t.getId());
		ticket.setPassengerName(t.getPassengerName());
		ticket.setTo(t.getTo());
		session.save(ticket);
	}

	// _______________________read_______________________
	public List<Ticket> getAllTickets() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
			Transaction transaction = transaction = session.beginTransaction();
		Query query = session.createQuery("from Ticket");
		List<Ticket> tickets = query.list();
		System.out.println(tickets.get(0).getTo());
		System.out.println(tickets.get(0).getDate());
		session.close();
		return tickets;
	}

	// ______________________________readOne__________________________
	public Ticket getOneticket(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
			
		Transaction tx = session.beginTransaction();
		String state = "select from Ticket where id = :id";
		Query query = session.createQuery(state);
		query.setInteger("id", id);
		Ticket t = new Ticket();
		List<Ticket> ticket = query.list();
		t.setDate(ticket.get(0).getDate());
		t.setFlightNumber(ticket.get(0).getFlightNumber());
		t.setFrom(ticket.get(0).getFrom());
		t.setTo(ticket.get(0).getTo());
		t.setPassengerName(ticket.get(0).getPassengerName());
		t.setId(id);
		tx.commit();
		session.close();
		return t;
	}

	// _________________________delete____________________

	public int deleteTicket(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
			Transaction tx = session.beginTransaction();
		String state = "delete from Ticket where id = :id";
		Query query = session.createQuery(state);
		query.setInteger("id", id);
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
	// ______________________update___________________________

	public int update(Ticket t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		
			Transaction tx= session.beginTransaction();
		String hql = "update Ticket set  passengerName =:passengerName , To = : To,From =:From, date = :date"
				+ " ,flightNumber =:flightNumber,   where id = :id";

		Query query = session.createQuery(hql);
		query.setInteger("id", t.getId());
		query.setString(" passengerName", t.getPassengerName());

		query.setString("To", t.getTo());
		query.setString("From", t.getFrom());

		query.setInteger("flightNumber", t.getFlightNumber());

		query.setString("date", t.getDate());
		int rowCount = query.executeUpdate();
		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		
				
		return rowCount;
	}
	//// _____________________getTicktById__________________
	// public Ticket getuserId(int id){
	// Ticket t = new Ticket();
	// Session session = SessionUtil.getSession();
	// Transaction tx = session.beginTransaction();
	//
	//
	// }
	// ____________________is_validـــــــــــــــــــ

	public boolean is_valid(int id) {
		boolean flage = false;
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			Transaction transaction = transaction = session.beginTransaction();

			Query query = session.createQuery("from Ticket");
			List<Ticket> tickets = query.list();
			for (int i = 0; i < tickets.size(); i++) {
				if (tickets.get(i).getId() == id) {
					flage = true;
				}
			}
		}

		catch (Exception e)

		{

			e.printStackTrace();

		}

			session.close();

		return flage;
	}

}
