import Spinner from "react-bootstrap/Spinner";
import React from "react";

export default function LoadingSpinner(props) {
  if (props.isLoading) {
    return (
      <Spinner animation="border" role="status">
        <span className="sr-only">Loading...</span>
      </Spinner>
    );
  } else {
    return null;
  }
}
