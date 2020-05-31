import React, { useState } from 'react';
import './styles.scss';
import Container from 'react-bootstrap/Container';
import Col from 'react-bootstrap/Col'
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

import LoadingSpinner from "../../components/LoadingSpinner";
import ResultsDisplay from "../../components/ResultsDisplay";

function regionSelect() {
  const regionNames = ["NA1", "BR1", "EUN1", "EUW1", "JP1", "KR", "LA1", "LA2", "OC1", "RU", "TR1"];
  return regionNames.map(function (region) {
    return (
      <option key={region}>{region}</option>
    )
  });
}

function Home() {
  const [summonerName, setSummonerName] = useState('');
  const [region, setRegion] = useState('NA1');
  const [loading, setLoading] = useState(false);
  const [loaded, setLoaded] = useState(false);
  const [error, setError] = useState(false);
  const [rating, setRating] = useState(null);

  const handleSummonerName = event => {
    setSummonerName(event.target.value);
  };

  const handleRegion = event => {
    setRegion(event.target.value);
  };

  const handleSubmit = event => {
    const form = event.currentTarget;
    if (form.checkValidity() === false) {
      event.preventDefault();
      event.stopPropagation();
    } else if (region !== '' && summonerName !== '') {
      setLoading(true);
      fetch(`/api/v1/tft-summoner-rating/?summonerName=${summonerName}&region=${region['text']}`)
        .then(res => res.json())
        .then(
          (result) => {
            setLoaded(true);
            setLoading(false);
            setRating(result);
          },
          (error) => {
            setLoaded(true);
            setLoading(false);
            setError(error);
          }
        );
    }

    event.preventDefault();
  };

  return (
    // TODO center this
    <Container>
      <Col>
        {/*TODO change copy*/}
        <h2>
          Are you tilted?
        </h2>
        <p>
          We take recent TFT games and determine how you are doing
        </p>
        {/*TODO make this a component*/}
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formBasicEmail">
            <Form.Label>Summoner Name</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter a summoner name"
              required
              value={summonerName}
              onChange={handleSummonerName}/>
          </Form.Group>

          <Form.Group controlId="exampleForm.ControlSelect1">
            <Form.Label>Region</Form.Label>
            <Form.Control
              as="select"
              required
              value={region}
              onChange={handleRegion}
            >
              {regionSelect()}
            </Form.Control>
          </Form.Group>
          <Button variant="primary" type="submit">
            Submit
          </Button>
        </Form>
      </Col>


      <LoadingSpinner
        isLoading={loading}
      />

      <ResultsDisplay
        isLoaded={loaded}
        rating={rating}
        error={error}
      />

    </Container>
  );
}

export default Home;