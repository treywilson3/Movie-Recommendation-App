package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class Click implements ActionListener {
    private CEOPanel ceoPanel;

    Click(CEOPanel ceoPanel){
        this.ceoPanel = ceoPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ceoPanel.getAddMovies()) {
            ceoPanel.addMoviesPanel();
        } else if (e.getSource() == ceoPanel.getAddMembers()) {
            ceoPanel.addMembersPanel();
        } else if (e.getSource() == ceoPanel.getAddEmployees()) {
            ceoPanel.addEmployeesPanel();
        } else if (e.getSource() == ceoPanel.getAddActors()) {
            ceoPanel.addActorPanel();
        } else if (e.getSource() == ceoPanel.getAddSettings()) {
            ceoPanel.settingsPanel();
        } else if (e.getSource() == ceoPanel.getAddMovie()) {
            ceoPanel.addMovie();
        } else if (e.getSource() == ceoPanel.getEmployeeInformation()) {
            ceoPanel.homeButton("");
            JTable table = ceoPanel.getCeoFunctions().getEmployeeInformation();
            JScrollPane pane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
            ceoPanel.add(pane);
        } else if (e.getSource() == ceoPanel.getSubmitAddMovie()) {
            String movieIDFinal = (String) ceoPanel.getMovieIDText().getText();
            String titleFinal = (String) ceoPanel.getMovieTitleText().getText();
            String ratingFinal = (String) ceoPanel.getMovieRatingText().getText();
            String genreFinal = (String) ceoPanel.getMovieGenreText().getText();
            String releaseDateFinal = (String) ceoPanel.getMovieReleaseDateText().getText();
            // call employee method
            ceoPanel.getCeoFunctions().addMovie(movieIDFinal, titleFinal, ratingFinal, genreFinal, releaseDateFinal);
            ceoPanel.confirmMessage(titleFinal + " has been added");
            ceoPanel.homeButton("");
        } else if (e.getSource() == ceoPanel.getDeleteMovie()) {
            ceoPanel.homeButton("");
            ceoPanel.getAllMovies = ceoPanel.getCeoFunctions().getAllMovies();
            JScrollPane pane = new JScrollPane(ceoPanel.getAllMovies, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ceoPanel.getAllMovies.setAutoResizeMode(ceoPanel.getAllMovies.AUTO_RESIZE_OFF);
            pane.getViewport().setBackground(Color.WHITE);
            ceoPanel.add(pane);
            c.fill = GridBagConstraints.NONE;
            c.ipady = 10;
            c.ipadx = 20;
            // c.insets = new Insets(0, 20, 20, 0); // side padding
            c.gridx = 0;
            c.gridy = 2;
            ceoPanel.add(ceoPanel.deleteMovie(), c);

        } else if (e.getSource() == ceoPanel.getSubmitDeleteMovie()) {
            if (ceoPanel.getAllMovies().getSelectedRow() != -1) {
                String movieIDFinal = ceoPanel.getAllMovies().getValueAt(ceoPanel.getAllMovies().getSelectedRow(), 0).toString();
                ceoPanel.getCeoFunctions().deleteMovie(movieIDFinal);
                ((DefaultTableModel) ceoPanel.getAllMovies().getModel()).removeRow(ceoPanel.getAllMovies().getSelectedRow());
                ceoPanel.confirmMessage(movieIDFinal + " has been removed from the Company DatabaseModel");
            }
        } else if (e.getSource() == ceoPanel.getAddMember()) {
            ceoPanel.addMember();
        } else if (e.getSource() == ceoPanel.getSubmitAddMember()) {
            String memberE = (String) ceoPanel.getAddMemberEmail().getText();
            String memberP = (String) ceoPanel.getAddMemberPassword().getText();
            String fnameFinal = (String) ceoPanel.getAddMemberFirstNameText().getText();
            String lnameFinal = (String) ceoPanel.getAddMemberLastNameText().getText();
            String phoneFinal = (String) ceoPanel.getAddPhoneText().getText();
            String addressFinal = (String) ceoPanel.getAddAddressText().getText();
            String cityFinal = (String) ceoPanel.getAddCityText().getText();
            String stateFinal = (String) ceoPanel.getAddStateText().getText();
            String zipFinal = (String) ceoPanel.getAddZipText().getText();
            // call method
            ceoPanel.getCeoFunctions().addMember(memberE, memberP, fnameFinal, lnameFinal, phoneFinal, addressFinal, cityFinal,
                    stateFinal, zipFinal);
            ceoPanel.confirmMessage(fnameFinal + " " + lnameFinal + " has been added");
            ceoPanel.homeButton("");
        } else if (e.getSource() == ceoPanel.getDeleteMember()) {
            ceoPanel.homeButton("");
            ceoPanel.getAllMembers = ceoPanel.getCeoFunctions().getAllMembers();
            JScrollPane pane = new JScrollPane(ceoPanel.getAllMembers, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ceoPanel.getAllMembers.setAutoResizeMode(ceoPanel.getAllMembers.AUTO_RESIZE_OFF);
            pane.getViewport().setBackground(Color.WHITE);
            ceoPanel.add(pane);
            c.fill = GridBagConstraints.NONE;
            c.ipady = 10;
            c.ipadx = 20;
            // c.insets = new Insets(0, 20, 20, 0); // side padding
            c.gridx = 0;
            c.gridy = 2;
            ceoPanel.add(ceoPanel.deleteMember(), c);
        } else if (e.getSource() == ceoPanel.getSubmitDeleteMember()) {
            if (ceoPanel.getAllMembers().getSelectedRow() != -1) {
                int memberID = (int) ceoPanel.getAllMembers().getValueAt(ceoPanel.getAllMembers().getSelectedRow(), 0);
                ceoPanel.getCeoFunctions().deleteMember(memberID);
                ((DefaultTableModel) ceoPanel.getAllMembers().getModel()).removeRow(ceoPanel.getAllMembers().getSelectedRow());
                ceoPanel.confirmMessage(memberID + " has been removed from the Company DatabaseModel");
            }
        } else if (e.getSource() == ceoPanel.getAddEmployee()) {
            ceoPanel.addEmployee();
        } else if (e.getSource() == ceoPanel.getSubmitAddEmployee()) {
            String email = (String) ceoPanel.getAddEmployeeEmail().getText();
            String password = (String) ceoPanel.getAddEmployeePassword().getText();
            String hireDateFinal = (String) ceoPanel.getAddHireDateText().getText();
            String firstNameFinal = (String) ceoPanel.getAddEmployeeFirstNameText().getText();
            String lastNameFinal = (String) ceoPanel.getAddEmployeeLastNameText().getText();
            String jobLocationFinal = (String) ceoPanel.getAddJobLocationText().getText();
            String positionFinal = (String) ceoPanel.getAddPositionText().getText();
            String salary = (String) ceoPanel.getAddSalaryText().getText();
            BigDecimal salaryFinal = new BigDecimal(salary);
            ceoPanel.getCeoFunctions().addEmployee(email, password, hireDateFinal, firstNameFinal, lastNameFinal,
                    jobLocationFinal, positionFinal, salaryFinal);
            ceoPanel.confirmMessage(firstNameFinal + " " + lastNameFinal + " has been added");
            ceoPanel.homeButton("");
        } else if (e.getSource() == ceoPanel.getDeleteEmployee()) {
            ceoPanel.homeButton("");
            ceoPanel.getAllEmployeesTable = ceoPanel.getCeoFunctions().getAllEmployees();
            JScrollPane pane = new JScrollPane(ceoPanel.getAllEmployeesTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ceoPanel.getAllEmployeesTable.setAutoResizeMode(ceoPanel.getAllEmployeesTable.AUTO_RESIZE_OFF);
            pane.getViewport().setBackground(Color.WHITE);
            ceoPanel.add(pane);
            c.fill = GridBagConstraints.NONE;
            c.ipady = 10;
            c.ipadx = 20;
            // c.insets = new Insets(0, 20, 20, 0); // side padding
            c.gridx = 0;
            c.gridy = 2;
            ceoPanel.add(ceoPanel.deleteEmployee(), c);
        } else if (e.getSource() == ceoPanel.getSubmitDeleteEmployee()) {
            if (ceoPanel.getAllEmployeesTable().getSelectedRow() != -1) {
                int employeeID = (int) ceoPanel.getAllEmployeesTable.getValueAt(ceoPanel.getAllEmployeesTable().getSelectedRow(), 0);
                ceoPanel.getCeoFunctions()().deleteEmployee(employeeID);
                ((DefaultTableModel) ceoPanel.getAllEmployeesTable().getModel())
                        .removeRow(ceoPanel.getAllEmployeesTable().getSelectedRow());
                ceoPanel.confirmMessage(employeeID + " has been removed from the Company DatabaseModel");
            }
        } else if (e.getSource() == ceoPanel.getAddActorButton()) {
            ceoPanel.addActor();
        } else if (e.getSource() == ceoPanel.getDeleteActorButton()) {
            ceoPanel.homeButton("");
            ceoPanel.getAllActors = ceoPanel.getCeoFunctions().getAllActors();
            JScrollPane pane = new JScrollPane(ceoPanel.getAllActors, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            ceoPanel.getAllActors.setAutoResizeMode(ceoPanel.getAllActors.AUTO_RESIZE_OFF);
            pane.getViewport().setBackground(Color.WHITE);
            ceoPanel.add(pane);
            c.fill = GridBagConstraints.NONE;
            c.ipady = 10;
            c.ipadx = 20;
            // c.insets = new Insets(0, 20, 20, 0); // side padding
            c.gridx = 0;
            c.gridy = 2;
            ceoPanel.add(ceoPanel.deleteActor(), c);
        } else if (e.getSource() == ceoPanel.getSubmitAddActor()) {
            String actorIDFinal = (String) ceoPanel.getAddActorIDText().getText();
            String actorFirstNameFinal = (String)ceoPanel.getAddActorFirstNameText().getText();
            String actorLastNameFinal = (String) ceoPanel.getAddActorLastNameText().getText();
            ceoPanel.getCeoFunctions().addActor(actorIDFinal, actorFirstNameFinal, actorLastNameFinal);
            ceoPanel.confirmMessage(actorFirstNameFinal + " " + actorLastNameFinal + " has been added");
            ceoPanel.homeButton("");
        } else if (e.getSource() == ceoPanel.getSubmitDeleteActor()) {
            if (ceoPanel.getAllActors().getSelectedRow() != -1) {
                String actorIDFinal = ceoPanel.getAllActors().getValueAt(ceoPanel.getAllActors().getSelectedRow(), 0).toString();
                ceoPanel.getCeoFunctions().deleteActor(actorIDFinal);
                ((DefaultTableModel) ceoPanel.getAllActors().getModel()).removeRow(ceoPanel.getAllActors().getSelectedRow());
                ceoPanel.confirmMessage(actorIDFinal + " has been removed from the Company DatabaseModel");
            }
        } else if (e.getSource() == ceoPanel.getUpdateEmail()) {
            ceoPanel.updateEmail();
        } else if (e.getSource() == ceoPanel.getSubmitEmail()) {
            String email = (String) ceoPanel.getEmailText().getText();
            ceoPanel.getCeoFunctions().updateEmail(email);
            ceoPanel.confirmMessage("Your email as been updated");
            ceoPanel.homeButton("");
        } else if (e.getSource() == ceoPanel.getUpdatePassword()) {
            ceoPanel.updatePassword();
        } else if (e.getSource() == ceoPanel.getSubmitPassword()) {
            String password = (String) ceoPanel.getPasswordText().getText();
            ceoPanel.getCeoFunctions().updatePassword(password);
            ceoPanel.confirmMessage("Your password has been updated");
            ceoPanel.homeButton("");
        } else if (e.getSource() == ceoPanel.getHomeButton()) {
            ceoPanel.ceoPage();
        }
    }
}
