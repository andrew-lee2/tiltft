import React, { useState } from 'react';
import {WiredButton, WiredItem, WiredCombo, WiredInput, WiredSpinner} from "react-wired-elements";
import './styles.scss';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import RegionSelect from "../../components/RegionSelect";
import LoadingSpinner from "../../components/LoadingSpinner";
import ResultsDisplay from "../../components/ResultsDisplay";



function Home() {
  const [summonerName, setSummonerName] = useState('');
  const [region, setRegion] = useState('');
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

  const handleSubmit = () => {
    if (region !== '' && summonerName !== '') {
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
        <Row>
          {/*// TODO make this wider*/}
          <Col>
            <WiredInput
              className={'summoner-name-bar'}
              placeholder={"Enter a summoner name"}
              onChange={handleSummonerName}
              value={summonerName}>
            </WiredInput>

          </Col>
          <Col>
            <RegionSelect
              onSelect={handleRegion}
              value={region}
            />
          </Col>
          <Col>
            <WiredButton
              onClick={handleSubmit}
            >
              Submit
            </WiredButton>
          </Col>

        </Row>
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