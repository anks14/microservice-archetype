#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )

package ${package}.routes;
public enum Routes {

    FETCH_ROUTE("direct:fetchRoute");

    private String routeCode;

    Routes(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRoutes() {
        return routeCode;
    }

}

