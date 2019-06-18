import React from "react";
import SearchResult from "./SearchResult";
import PlaceOrder from "../buy/PlaceOrder";

export default function MainBody(props) {
    switch(props.body){
        case "search":
            return (<SearchResult />);
        case "ordering":
            return (<PlaceOrder />);
        default:
            return (<SearchResult />);
    }
};

