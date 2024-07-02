package com.sosaco.orderfast.controllers.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.Objects;

public class MenuButton extends VBox {

    public enum Color {
        RED,
        GREEN,
        YELLOW,
        BROWN
    }

    public enum Icon {
        SETTINGS,
        INVENTORY,
        RECIPES,
        ORDERS
    }

    @FXML
    private Button button;

    @FXML
    private Label label;

    @FXML
    private Region svgPath;

    //props for the icon, color and the text that goes with the button
    private Icon icon;
    private String text;
    private Color color;

    public MenuButton(){
        //make the class a component
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/sosaco/orderfast/views/components/menu-button.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        initElements();
    }

    private void initElements() {
        //add event listener to the button
        button.setOnMouseClicked(this::changePage);
    }

    private void changePage(MouseEvent e){
        //get the view with the id of the button
        String view = "/com/sosaco/orderfast/views/scenes/" + button.getParent().getId() + "-view.fxml";

        //create the new pane with the view
        Parent pane = null;
        try {
            pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(view)));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        //set the pane as the new root
        button.getScene().setRoot(pane);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        label.setText(text);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        String rgbColor = switch (color) {
            case RED -> "#E26D5C";
            case GREEN -> "#C9CBA3";
            case YELLOW -> "#FFE1A8";
            case BROWN -> "#723d46";
        };
        //set the background color according to the props
        String style = "-fx-background-color: " + rgbColor + ";";
        button.setStyle(style);
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;

        String svgIcon  = switch (icon){
            case RECIPES -> "M418.089,47.697l-15.133-24.248c3.545-2.263,5.913-6.214,5.913-10.726C408.869,5.696,403.18,0,396.147,0   H112.098C98.843,0,86.765,5.402,78.092,14.089c-8.688,8.652-14.306,20.759-14.306,33.993v422.023   c0,23.134,18.762,41.895,41.896,41.895h307.237c19.49,0,35.296-15.792,35.296-35.275V82.467   C448.215,64.742,435.099,50.24,418.089,47.697z M151.738,180.34l27.996,33.145c2.2,2.614,5.886,3.118,8.225,1.136l1.149-0.96   c2.34-1.983,2.48-5.703,0.266-8.316l-28.15-33.334c-5.676-6.718-3.293-12.169,0.616-15.469c3.909-3.3,9.682-4.736,15.357,1.983   l28.15,33.334c2.2,2.613,5.899,3.11,8.239,1.128l1.135-0.96c2.34-1.976,2.48-5.696,0.266-8.309l-27.996-33.152   c-10.159-12.029,5.66-24.682,15.581-12.926c11.896,14.082,26.441,31.309,26.441,31.309c18.341,21.565,18.412,31.12,16.408,44.355   c-1.611,10.663-4.288,18.243,7.09,31.722l3.615,4.274l-15.959,18.895l-6.292-7.433c-11.377-13.48-19.294-12.114-30.083-12.303   c-13.382-0.238-22.784-1.934-40.971-23.616c0,0-14.544-17.228-26.44-31.31C126.461,181.783,141.579,168.304,151.738,180.34z    M204.829,448.226h-9.038v-27.33l-8.968,18.972h-6.46l-9.234-19.077v27.436h-9.024V400.06h8.659l12.821,27.309l12.568-27.309h8.674   V448.226z M250.115,408.376h-22.489v11.448h19.183v8.253h-19.183v11.833h22.489v8.316h-31.513V400.06h31.513V408.376z    M298.315,448.226h-7.972l-19.757-30.084v30.084h-9.024V400.06h7.973l19.756,30.02v-30.02h9.024V448.226z M269.199,302.586   l15.96-18.902l47.01,55.676l-18.622,15.743L269.199,302.586z M346.601,431.656c0,2.508-0.462,4.834-1.345,6.914   c-0.897,2.088-2.158,3.896-3.741,5.367c-1.584,1.464-3.475,2.62-5.619,3.447c-2.13,0.812-4.456,1.226-6.908,1.226   c-2.438,0-4.764-0.414-6.908-1.226c-2.144-0.827-4.021-1.99-5.576-3.454c-1.57-1.472-2.816-3.272-3.699-5.36   c-0.897-2.08-1.345-4.406-1.345-6.914V400.06h9.024v31.274c0,2.823,0.77,5.051,2.298,6.613c1.541,1.583,3.572,2.347,6.207,2.347   s4.68-0.77,6.249-2.354c1.57-1.584,2.326-3.748,2.326-6.607V400.06h9.038V431.656z M367.086,181.405   c-6.418,15.644-17.95,44.347-30.841,59.627c-29.985,37.608-30.392,3.538-55.108,31.94l-69.359,82.131l-18.537-15.665l-0.309,0.182   c0,0,0.084-0.106,0.21-0.253c2.928-3.461,44.179-52.306,79.672-94.348c35.114-41.58,64.426-76.302,70.605-83.609   C356.087,146.396,377.105,157.052,367.086,181.405z M90.198,48.65v-0.568c0-5.57,2.382-11.14,6.529-15.28   c4.134-4.147,9.57-6.396,15.371-6.396h261.573l13.886,22.244H90.198z";
            case INVENTORY -> "M29 0C27.894531 0 27 0.898438 27 2L27 4C27 5.101563 27.894531 6 29 6L39 6C40.105469 6 41 5.101563 41 4L41 2C41 0.898438 40.105469 0 39 0 Z M 28.09375 7.875C27.164063 9.613281 26.363281 11.855469 25.78125 13.65625L40.53125 22L44 22L44 21.8125C44 19.492188 42.09375 12.074219 39.84375 7.90625C39.574219 7.964844 39.285156 8 39 8L29 8C28.6875 8 28.382813 7.941406 28.09375 7.875 Z M 14.625 13.78125C9.632813 13.78125 5.6875 17.167969 4.65625 22L12.25 22L19.59375 15.0625C18.089844 14.222656 16.398438 13.78125 14.625 13.78125 Z M 23.1875 14.6875C22.980469 14.710938 22.785156 14.816406 22.625 14.96875L15.15625 22L36.46875 22L23.8125 14.8125C23.621094 14.703125 23.394531 14.664063 23.1875 14.6875 Z M 2.84375 24C1.273438 24 0 25.273438 0 26.84375L0 30.15625C0 31.726563 1.273438 33 2.84375 33L47.15625 33C48.726563 33 50 31.726563 50 30.15625L50 26.84375C50 25.273438 48.726563 24 47.15625 24 Z M 3 35L3 36C3 36.195313 3.007813 36.304688 6.4375 47.4375C6.457031 47.503906 6.527344 47.65625 6.5625 47.71875C7.160156 48.789063 7.816406 50 9.21875 50L40.78125 50C42.519531 50 43.117188 48.507813 43.5625 47.4375C46.988281 36.304688 47 36.195313 47 36L47 35L37 35L37 45L34 45L34 35L30 35L30 45L27 45L27 35L23 35L23 45L20 45L20 35L16 35L16 45L13 45L13 35Z";
            case SETTINGS -> "M53.1708 21.4624C51.7577 21.4624 51.4219 20.6527 52.4223 19.6537L54.231 17.8422C55.9002 16.1758 55.9002 13.4763 54.231 11.807L48.1958 5.77046C46.528 4.10265 43.8271 4.10123 42.1578 5.77189C42.1578 5.77189 41.3495 6.5816 40.3491 7.58058C39.3516 8.57956 38.5404 8.24372 38.5404 6.83063V4.26915C38.5419 1.91115 36.6335 0.00426915 34.2741 0L25.7344 0.00142305C23.3736 0.00142305 21.4624 1.91258 21.4624 4.27057C21.4624 4.27057 21.4624 5.41612 21.4624 6.82779C21.4624 8.23803 20.6527 8.57244 19.6537 7.57489L17.8465 5.76762C16.1786 4.10123 13.482 4.10123 11.8099 5.76619L5.77331 11.8042C4.10692 13.4734 4.10407 16.1715 5.77473 17.845C5.77473 17.845 6.58445 18.6547 7.58343 19.6551C8.58241 20.6541 8.24657 21.4638 6.83063 21.4638H4.26915C1.91115 21.4638 0 23.375 0 25.733V34.2713C0 36.6293 1.91115 38.5404 4.26915 38.5404C4.26915 38.5404 5.41612 38.5404 6.82921 38.5404C8.2423 38.5404 8.57814 39.3501 7.57916 40.3491L5.77046 42.1578C4.10265 43.8256 4.10265 46.5266 5.77046 48.1958L11.807 54.2338C13.4763 55.9002 16.1772 55.9016 17.8465 54.2338C17.8465 54.2338 18.6562 53.4255 19.6537 52.4251C20.6513 51.4276 21.4624 51.762 21.4624 53.1736V55.7294C21.4624 57.7943 22.9267 59.5147 24.8735 59.9118C25.151 59.9673 25.4413 60 25.7373 60H34.2727C36.6321 59.9986 38.5419 58.0874 38.5447 55.7294C38.5447 55.7294 38.5447 54.5839 38.5447 53.1708C38.5447 51.7577 39.3544 51.4219 40.3534 52.4208L42.1621 54.2295C43.8313 55.9002 46.5323 55.9002 48.2029 54.2324L54.2381 48.1958C55.9059 46.528 55.9059 43.8242 54.2381 42.155C54.2381 42.155 53.4298 41.3481 52.4294 40.3463C51.4318 39.3487 51.7648 38.5376 53.1751 38.5376H55.7294C58.0874 38.5376 59.9986 36.6264 59.9986 34.2684V25.7301C59.9986 23.3722 58.0874 21.461 55.7294 21.461C55.7294 21.461 54.5839 21.4624 53.1708 21.4624ZM29.9979 43.995C22.2679 43.995 16.0022 37.7307 16.0022 30.0007C16.0022 22.2707 22.2679 16.005 29.9979 16.005C37.7279 16.005 43.9936 22.2707 43.9936 30.0007C43.9936 37.7307 37.7279 43.995 29.9979 43.995Z";
            case ORDERS -> "M5.9,18l1.2,2.4C7.3,20.8,7.6,21,8,21h17c0.4,0,0.7-0.2,0.9-0.6l1.2-2.4H5.9z M4,17h1.4h22.2H29c0.6,0,1-0.4,1-1s-0.4-1-1-1h-1c-0.2-5.3-4.1-9.7-9.1-10.8C18.9,4,19,3.8,19,3.5C19,2.1,17.9,1,16.5,1   S14,2.1,14,3.5c0,0.3,0.1,0.5,0.1,0.7C9.1,5.3,5.3,9.7,5,15H4c-0.6,0-1,0.4-1,1S3.4,17,4,17z M24.6,22.3C24.5,22.1,24.2,22,24,22c-0.4,0-0.7,0-1.1,0.1l-1.1,1.5C20.7,25.1,18.9,26,17,26h0h-0.3H16h-1.3H14  c-0.6,0-1-0.4-1-1s0.4-1,1-1h3.5c0.3-0.3,0.5-0.8,0.5-1.3c0,0,0-0.1,0-0.1c0-0.4-0.3-0.6-0.7-0.6h-4c-2.4,0-4.3,1.1-5.4,2.8  l-1.8,2.8c-0.1,0.2-0.1,0.5,0,0.7l2,3.3c0.1,0.2,0.2,0.3,0.4,0.3c0,0,0.1,0,0.1,0c0.1,0,0.3,0,0.4-0.1c2.5-1.7,5.5-2.6,8.5-2.6  c2.2,0,4.2-1.2,5.2-3.1l1.8-3.2C24.7,22.8,24.7,22.5,24.6,22.3z";
        };

        String svgWidth = switch (icon){
            case RECIPES -> "45px";
            case INVENTORY, SETTINGS, ORDERS -> "60px";
        };

        //set the icon and the width of it according to the props
        String shape = " -fx-shape: \"" + svgIcon + "\" ;";
        String width = " -fx-max-width: " + svgWidth + ";";
        //get the current style and the new ones
        String style = svgPath.getStyle() + shape + width;
        svgPath.setStyle(style);
    }

}
