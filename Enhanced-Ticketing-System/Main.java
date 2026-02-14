import edu.ticket.facade.TicketingFacade;
import edu.ticket.factory.TicketFactory;
import edu.ticket.logger.ConsoleLogger;
import edu.ticket.logger.Logger;
import edu.ticket.model.Channel;
import edu.ticket.model.Ticket;
import edu.ticket.strategy.assign.AssignStrategy;
import edu.ticket.strategy.assign.DefaultAssignStrategy;
import edu.ticket.strategy.input.InputHandlerStrategy;
import edu.ticket.strategy.input.WebInputHandler;
import edu.ticket.strategy.input.EmailInputHandler;
import edu.ticket.strategy.response.EmailResponseStrategy;
import edu.ticket.strategy.response.ResponseStrategy;
import edu.ticket.strategy.response.SmsResponseStrategy;

public class Main {

    public static void main(String[] args) {

        Logger logger = new ConsoleLogger();
        TicketFactory factory = new TicketFactory();
        AssignStrategy assignStrategy = new DefaultAssignStrategy();

        // --- Scenario 1: Bug report from WEB, response via Email ---
        System.out.println("=== Scenario 1: Web Bug Report ===");
        InputHandlerStrategy webHandler = new WebInputHandler();
        ResponseStrategy emailResponse = new EmailResponseStrategy();

        TicketingFacade webFacade = new TicketingFacade(
                webHandler, factory, assignStrategy, emailResponse, logger
        );
        Ticket ticket1 = webFacade.process("I see a very very very BAD BUG :/", Channel.WEB);
        System.out.println("Final: " + ticket1.getSummary());

        System.out.println();

        // --- Scenario 2: Request from EMAIL, response via SMS ---
        System.out.println("=== Scenario 2: Email Support Request ===");
        InputHandlerStrategy emailHandler = new EmailInputHandler();
        ResponseStrategy smsResponse = new SmsResponseStrategy();

        TicketingFacade emailFacade = new TicketingFacade(
                emailHandler, factory, assignStrategy, smsResponse, logger
        );
        Ticket ticket2 = emailFacade.process("I need help with my account.", Channel.EMAIL);
        System.out.println("Final: " + ticket2.getSummary());
    }
}
