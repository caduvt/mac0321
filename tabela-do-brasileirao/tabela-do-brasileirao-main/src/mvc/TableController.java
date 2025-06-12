package src.mvc;

public class TableController implements Controller {

    View view;
    LeagueStatsModel model;

    public TableController(LeagueStatsModel theModel) {

        view = new TableView(this, theModel);

        model = theModel;

        view.show();

    }

}
