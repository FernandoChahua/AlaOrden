import React from "react";
import SearchResult from "./SearchResult";
import PlaceOrder from "../buy/PlaceOrder";

export default function MainBody(props) {
    switch(props.body){
        case "search":
            return (<SearchResult {...props} />);
        case "ordering":
            return (<PlaceOrder {...props} />);
        default:
            return (<SearchResult {...props} />);
    }
};

