package View;

public class Focus implements FocusListener {
    private CEOPanel ceoPanel;

    Focus(CEOPanel ceoPanel){
        this.ceoPanel = ceoPanel;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == ceoPanel.getAddMemberEmail) {
            ceoPanel.getAddMemberEmail.setForeground(Color.BLACK);
            if (ceoPanel.getAddMemberEmail.getText().equals(ceoPanel.getAddMemberEmailPrompt)) {
                ceoPanel.getAddMemberEmail.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddMemberPassword) {
            ceoPanel.getAddMemberPassword.setForeground(Color.BLACK);
            if (ceoPanel.getAddMemberPassword.getText().equals(ceoPanel.getAddMemberPasswordPrompt)) {
                ceoPanel.getAddMemberPassword.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddMemberFirstNameText) {
            ceoPanel.getAddMemberFirstNameText.setForeground(Color.BLACK);
            if (ceoPanel.getAddMemberFirstNameText.getText().equals(ceoPanel.getAddMemberFirstNameTextPrompt)) {
                ceoPanel.getAddMemberFirstNameText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddMemberLastNameText) {
            ceoPanel.getAddMemberLastNameText.setForeground(Color.BLACK);
            if (ceoPanel.getAddMemberLastNameText.getText().equals(ceoPanel.getAddMemberLastNameTextPrompt)) {
                ceoPanel.getAddMemberLastNameText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddPhoneText) {
            ceoPanel.getAddPhoneText.setForeground(Color.BLACK);
            if (ceoPanel.getAddPhoneText.getText().equals(ceoPanel.getAddPhoneTextPrompt)) {
                ceoPanel.getAddPhoneText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddAddressText) {
            ceoPanel.getAddAddressText.setForeground(Color.BLACK);
            if (ceoPanel.getAddAddressText.getText().equals(ceoPanel.getAddAddressTextPrompt)) {
                ceoPanel.getAddAddressText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddCityText) {
            ceoPanel.getAddCityText.setForeground(Color.BLACK);
            if (ceoPanel.getAddCityText.getText().equals(ceoPanel.getAddCityTextPrompt)) {
                ceoPanel.getAddCityText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddStateText) {
            ceoPanel.getAddStateText.setForeground(Color.BLACK);
            if (ceoPanel.getAddStateText.getText().equals(ceoPanel.getAddStateTextPrompt)) {
                ceoPanel.getAddStateText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddZipText) {
            ceoPanel.getAddZipText.setForeground(Color.BLACK);
            if (ceoPanel.getAddZipText.getText().equals(ceoPanel.getAddZipTextPrompt)) {
                ceoPanel.getAddZipText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getMovieIDText) {
            ceoPanel.getMovieIDText.setForeground(Color.BLACK);
            if (ceoPanel.getMovieIDText.getText().equals(ceoPanel.getMovieIDTextPrompt)) {
                ceoPanel.getMovieIDText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getMovieTitleText) {
            ceoPanel.getMovieTitleText.setForeground(Color.BLACK);
            if (ceoPanel.getMovieTitleText.getText().equals(ceoPanel.getMovieTitleTextPrompt)) {
                ceoPanel.getMovieTitleText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getMovieRatingText) {
            ceoPanel.getMovieRatingText.setForeground(Color.BLACK);
            if (ceoPanel.getMovieRatingText.getText().equals(ceoPanel.getMovieRatingTextPrompt)) {
                ceoPanel.getMovieRatingText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getMovieGenreText) {
            ceoPanel.getMovieGenreText.setForeground(Color.BLACK);
            if (ceoPanel.getMovieGenreText.getText().equals(ceoPanel.getMovieGenreTextPrompt)) {
                ceoPanel.getMovieGenreText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getMovieReleaseDateText) {
            ceoPanel.getMovieReleaseDateText.setForeground(Color.BLACK);
            if (ceoPanel.getMovieReleaseDateText.getText().equals(ceoPanel.getMovieReleaseDateTextPrompt)) {
                ceoPanel.getMovieReleaseDateText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddEmployeeEmail) {
            ceoPanel.getAddEmployeeEmail.setForeground(Color.BLACK);
            if (ceoPanel.getAddEmployeeEmail.getText().equals(ceoPanel.getAddEmployeeEmailPrompt)) {
                ceoPanel.getAddEmployeeEmail.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddEmployeePassword) {
            ceoPanel.getAddEmployeePassword.setForeground(Color.BLACK);
            if (ceoPanel.getAddEmployeePassword.getText().equals(ceoPanel.getAddEmployeePasswordPrompt)) {
                ceoPanel.getAddEmployeePassword.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddHireDateText) {
            ceoPanel.getAddHireDateText.setForeground(Color.BLACK);
            if (ceoPanel.getAddHireDateText.getText().equals(ceoPanel.getAddHireDateTextPrompt)) {
                ceoPanel.getAddHireDateText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddEmployeeFirstNameText) {
            ceoPanel.getAddEmployeeFirstNameText.setForeground(Color.BLACK);
            if (ceoPanel.getAddEmployeeFirstNameText.getText().equals(ceoPanel.getAddEmployeeFirstNameTextPrompt)) {
                ceoPanel.getAddEmployeeFirstNameText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddEmployeeLastNameText) {
            ceoPanel.getAddEmployeeLastNameText.setForeground(Color.BLACK);
            if (ceoPanel.getAddEmployeeLastNameText.getText().equals(ceoPanel.getAddEmployeeLastNameTextPrompt)) {
                ceoPanel.getAddEmployeeLastNameText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddJobLocationText) {
            ceoPanel.getAddJobLocationText.setForeground(Color.BLACK);
            if (ceoPanel.getAddJobLocationText.getText().equals(ceoPanel.getAddJobLocationTextPrompt)) {
                ceoPanel.getAddJobLocationText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddPositionText) {
            ceoPanel.getAddPositionText.setForeground(Color.BLACK);
            if (ceoPanel.getAddPositionText.getText().equals(ceoPanel.getAddPositionTextPrompt)) {
                ceoPanel.getAddPositionText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddSalaryText) {
            ceoPanel.getAddSalaryText.setForeground(Color.BLACK);
            if (ceoPanel.getAddSalaryText.getText().equals(ceoPanel.getAddSalaryTextPrompt)) {
                ceoPanel.getAddSalaryText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddActorIDText) {
            ceoPanel.getAddActorIDText.setForeground(Color.BLACK);
            if (ceoPanel.getAddActorIDText.getText().equals(ceoPanel.getAddActorIDTextPrompt)) {
                ceoPanel.getAddActorIDText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddActorFirstNameText) {
            ceoPanel.getAddActorFirstNameText.setForeground(Color.BLACK);
            if (ceoPanel.getAddActorFirstNameText.getText().equals(ceoPanel.getAddActorFirstNameTextPrompt)) {
                ceoPanel.getAddActorFirstNameText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getAddActorLastNameText) {
            ceoPanel.getAddActorLastNameText.setForeground(Color.BLACK);
            if (ceoPanel.getAddActorLastNameText.getText().equals(ceoPanel.getAddActorLastNameTextPrompt)) {
                ceoPanel.getAddActorLastNameText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getEmailText) {
            ceoPanel.getEmailText.setForeground(Color.BLACK);
            if (ceoPanel.getEmailText.getText().equals(ceoPanel.getEmailTextPrompt)) {
                ceoPanel.getEmailText.setText("");
            }
        } else if (e.getSource() == ceoPanel.getPasswordText) {
            ceoPanel.getPasswordText.setForeground(Color.BLACK);
            if (ceoPanel.getPasswordText.getText().equals(ceoPanel.getPasswordTextPrompt)) {
                ceoPanel.getPasswordText.setText("");
            }
        }

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e.getSource() == ceoPanel.getAddMemberEmail) {
            if (ceoPanel.getAddMemberEmail.getText().length() == 0) {
                ceoPanel.getAddMemberEmail.setForeground(Color.GRAY);
                ceoPanel.getAddMemberEmail.setText(ceoPanel.getAddMemberEmailPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddMemberPassword) {
            if (ceoPanel.getAddMemberPassword.getText().length() == 0) {
                ceoPanel.getAddMemberPassword.setForeground(Color.GRAY);
                ceoPanel.getAddMemberPassword.setText(ceoPanel.getAddMemberPasswordPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddMemberFirstNameText) {
            if (ceoPanel.getAddMemberFirstNameText.getText().length() == 0) {
                ceoPanel.getAddMemberFirstNameText.setForeground(Color.GRAY);
                ceoPanel.getAddMemberFirstNameText.setText(ceoPanel.getAddMemberFirstNameTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddMemberLastNameText) {
            if (ceoPanel.getAddMemberLastNameText.getText().length() == 0) {
                ceoPanel.getAddMemberLastNameText.setForeground(Color.GRAY);
                ceoPanel.getAddMemberLastNameText.setText(ceoPanel.getAddMemberLastNameTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddPhoneText) {
            if (ceoPanel.getAddPhoneText.getText().length() == 0) {
                ceoPanel.getAddPhoneText.setForeground(Color.GRAY);
                ceoPanel.getAddPhoneText.setText(ceoPanel.getAddPhoneTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddAddressText) {
            if (ceoPanel.getAddAddressText.getText().length() == 0) {
                ceoPanel.getAddAddressText.setForeground(Color.GRAY);
                ceoPanel.getAddAddressText.setText(ceoPanel.getAddAddressTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddCityText) {
            if (ceoPanel.getAddCityText.getText().length() == 0) {
                ceoPanel.getAddCityText.setForeground(Color.GRAY);
                ceoPanel.getAddCityText.setText(ceoPanel.getAddCityTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddStateText) {
            if (ceoPanel.getAddStateText.getText().length() == 0) {
                ceoPanel.getAddStateText.setForeground(Color.GRAY);
                ceoPanel.getAddStateText.setText(ceoPanel.getAddStateTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddZipText) {
            if (ceoPanel.getAddZipText.getText().length() == 0) {
                ceoPanel.getAddZipText.setForeground(Color.GRAY);
                ceoPanel.getAddZipText.setText(ceoPanel.getAddZipTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getMovieIDText) {
            if (ceoPanel.getMovieIDText.getText().length() == 0) {
                ceoPanel.getMovieIDText.setForeground(Color.GRAY);
                ceoPanel.getMovieIDText.setText(ceoPanel.getMovieIDTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getMovieTitleText) {
            if (ceoPanel.getMovieTitleText.getText().length() == 0) {
                ceoPanel.getMovieTitleText.setForeground(Color.GRAY);
                ceoPanel.getMovieTitleText.setText(ceoPanel.getMovieTitleTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getMovieRatingText) {
            if (ceoPanel.getMovieRatingText.getText().length() == 0) {
                ceoPanel.getMovieRatingText.setForeground(Color.GRAY);
                ceoPanel.getMovieRatingText.setText(ceoPanel.getMovieRatingTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getMovieGenreText) {
            if (ceoPanel.getMovieGenreText.getText().length() == 0) {
                ceoPanel.getMovieGenreText.setForeground(Color.GRAY);
                ceoPanel.getMovieGenreText.setText(ceoPanel.getMovieGenreTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getMovieReleaseDateText) {
            if (ceoPanel.getMovieReleaseDateText.getText().length() == 0) {
                ceoPanel.getMovieReleaseDateText.setForeground(Color.GRAY);
                ceoPanel.getMovieReleaseDateText.setText(ceoPanel.getMovieReleaseDateTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddEmployeeEmail) {
            if (ceoPanel.getAddEmployeeEmail.getText().length() == 0) {
                ceoPanel.getAddEmployeeEmail.setForeground(Color.GRAY);
                ceoPanel.getAddEmployeeEmail.setText(ceoPanel.getAddEmployeeEmailPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddEmployeePassword) {
            if (ceoPanel.getAddEmployeePassword.getText().length() == 0) {
                ceoPanel.getAddEmployeePassword.setForeground(Color.GRAY);
                ceoPanel.getAddEmployeePassword.setText(ceoPanel.getAddEmployeePasswordPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddHireDateText) {
            if (ceoPanel.getAddHireDateText.getText().length() == 0) {
                ceoPanel.getAddHireDateText.setForeground(Color.GRAY);
                ceoPanel.getAddHireDateText.setText(ceoPanel.getAddHireDateTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddEmployeeFirstNameText) {
            if (ceoPanel.getAddEmployeeFirstNameText.getText().length() == 0) {
                ceoPanel.getAddEmployeeFirstNameText.setForeground(Color.GRAY);
                ceoPanel.getAddEmployeeFirstNameText.setText(ceoPanel.getAddEmployeeFirstNameTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddEmployeeLastNameText) {
            if (ceoPanel.getAddEmployeeLastNameText.getText().length() == 0) {
                ceoPanel.getAddEmployeeLastNameText.setForeground(Color.GRAY);
                ceoPanel.getAddEmployeeLastNameText.setText(ceoPanel.getAddEmployeeLastNameTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddJobLocationText) {
            if (ceoPanel.getAddJobLocationText.getText().length() == 0) {
                ceoPanel.getAddJobLocationText.setForeground(Color.GRAY);
                ceoPanel.getAddJobLocationText.setText(ceoPanel.getAddJobLocationTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddPositionText) {
            if (ceoPanel.getAddPositionText.getText().length() == 0) {
                ceoPanel.getAddPositionText.setForeground(Color.GRAY);
                ceoPanel.getAddPositionText.setText(ceoPanel.getAddPositionTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddSalaryText) {
            if (ceoPanel.getAddSalaryText.getText().length() == 0) {
                ceoPanel.getAddSalaryText.setForeground(Color.GRAY);
                ceoPanel.getAddSalaryText.setText(ceoPanel.getAddSalaryTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddActorIDText) {
            if (ceoPanel.getAddActorIDText.getText().length() == 0) {
                ceoPanel.getAddActorIDText.setForeground(Color.GRAY);
                ceoPanel.getAddActorIDText.setText(ceoPanel.getAddActorIDTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddActorFirstNameText) {
            if (ceoPanel.getAddActorFirstNameText.getText().length() == 0) {
                ceoPanel.getAddActorFirstNameText.setForeground(Color.GRAY);
                ceoPanel.getAddActorFirstNameText.setText(ceoPanel.getAddActorFirstNameTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getAddActorLastNameText) {
            if (ceoPanel.getAddActorLastNameText.getText().length() == 0) {
                ceoPanel.getAddActorLastNameText.setForeground(Color.GRAY);
                ceoPanel.getAddActorLastNameText.setText(ceoPanel.getAddActorLastNameTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getEmailText) {
            if (ceoPanel.getEmailText.getText().length() == 0) {
                ceoPanel.getEmailText.setForeground(Color.GRAY);
                ceoPanel.getEmailText.setText(ceoPanel.getEmailTextPrompt);
            }
        } else if (e.getSource() == ceoPanel.getPasswordText) {
            if (ceoPanel.getPasswordText.getText().length() == 0) {
                ceoPanel.getPasswordText.setForeground(Color.GRAY);
                ceoPanel.getPasswordText.setText(ceoPanel.getPasswordTextPrompt);
            }
        }

    }
}
