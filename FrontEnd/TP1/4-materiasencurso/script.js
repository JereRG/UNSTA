const materiasAprobadas = [
    {
        nombre: "Inglés A2",
        situacion: "Cursando",
        profesor: "Alvarez Carlos Ariel",
        nota: "-",
    },
    {
        nombre: "Seminario Informático II",
        situacion: "Cursando",
        profesor: "Florencia Nucci",
        nota: "-",
    },
    {
        nombre: "Formación Humanística II",
        situacion: "Cursando",
        profesor: "Ariel Diaz",
        nota: "-",
    },
    {
        nombre: "Desarrollo Front End",
        situacion: "Cursando",
        profesor: "Tulio Ruesjas Martin",
        nota: "-",
    },
    {
        nombre: "Fund. del Control de Calidad",
        situacion: "Cursando",
        profesor: "Tulio Ruesjas Martin",
        nota: "-",
    },
];

let tableBody = document.getElementById('team-member-rows');

const itemsOnPage = 9;

const numberOfPages = Math.ceil(materiasAprobadas.length / itemsOnPage);

const start = (new URLSearchParams(window.location.search)).get('page') || 1;

const mappedRecords = materiasAprobadas
    .filter((_, i) =>(
        ((start - 1) * itemsOnPage) < i + 1) &&
        (i+1 <= start * itemsOnPage)
    )
    .map(
        (teamMember) => {
            return `
            <tr>
                <td class="team-member-profile">
                    <span class="profile-info">
                        <span class="profile-info__name">
                            ${teamMember.nombre}
                        </span>
                    </span>
                </td>
                <td>
                    <span class="status status--${teamMember.situacion}">
                        ${teamMember.situacion}
                    </span>
                </td>
                <td>${teamMember.profesor}</td>
                <td>${teamMember.nota}</td>
            </tr>`;
        });

tableBody.innerHTML = mappedRecords.join('');


