# Backend — Documentazione esercizio

Breve descrizione: il backend gestisce le entità principali dell'esercitazione (utenti, partite, giocate) e fornisce le API per il frontend.

## Stato
- Prima versione completata: implementati gli schemi principali e le API di base.
- Prossimi passi: implementare la pagina del gioco (game) e le API di sincronizzazione del turno.

## Database
### Tabella `utenti`
- `id` (PK)
- `ip` (string)

### Tabella `partite`
- `id` (PK)
- `stato` (es. "waiting", "in_corso", "terminata")
- `turno` (numero o identificatore di turno)

### Tabella `giocate`
- `id` (PK)
- `id_utente` (FK -> `utenti.id`)
- `id_partita` (FK -> `partite.id`)
- `turno` (numero)
- `mossa` (descrizione / payload della giocata)

## API 
Le API effettivamente implementate nel backend (controller disponibili):

- `GET /users` — restituisce la lista utenti (response: `List<UserDto>`)
- `POST /users/add` — aggiunge un utente (body: `AddUserRequestDto` con `username` e `ip`, response: `AddUserResponse`)
- `DELETE /users/delete/{userId}` — rimuove un utente (response: `RemoveUserResponse`)

Nota: al momento sono presenti solo i controller relativi agli utenti. Le API per `partite` e `giocate` non sono ancora implementate nel codice (non sono stati trovati controller corrispondenti). Se vuoi, posso:

- aggiungere i controller per `partite`/`giocate` secondo lo schema del DB, oppure
- aggiornare `be/be.md` nuovamente quando quei controller saranno implementati.

## Avvio e sviluppo
- Controlla la cartella `be/` per i dettagli di avvio specifici del progetto.
- Assicurati di impostare le variabili d'ambiente per la connessione al DB prima dell'avvio.


